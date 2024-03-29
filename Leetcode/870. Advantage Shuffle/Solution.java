/* https://leetcode.com/problems/advantage-shuffle/

Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

Example 1:
Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

Example 2:
Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]
 
Note:
1 <= A.length = B.length <= 10000
0 <= A[i] <= 10^9
0 <= B[i] <= 10^9
*/

class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int n : A) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int[] ret = new int[A.length];
        for(int i = 0 ; i < B.length ; i++) {
            ret[i] = getBest(map, B[i]);
        }
        return ret;
    }
    
    public int getBest(TreeMap<Integer, Integer> map, int val) {
        Integer ret = map.higherKey(val);
        if(ret == null) ret = map.firstKey(); //use lowest number if higher number is not available
        
        map.put(ret, map.get(ret) - 1);
        if(map.get(ret) == 0) map.remove(ret);
        
        return ret;
    }
}
