/* https://leetcode.com/problems/minimum-increment-to-make-array-unique/

Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.

Return the least number of moves to make every value in A unique.

 

Example 1:

Input: [1,2,2]
Output: 1
Explanation:  After 1 move, the array could be [1, 2, 3].
Example 2:

Input: [3,2,1,2,1,7]
Output: 6
Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
It can be shown with 5 or less moves that it is impossible for the array to have all unique values.

*/

class Solution { // times out
    public int minIncrementForUnique(int[] A) {
        int inc = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < A.length ; i++) {
            if(!set.contains(A[i]))
                set.add(A[i]);
            else {
                int n = 0;
                while(set.contains(A[i] + n)) {
                    n++;
                }
                set.add(A[i] + n);
                inc += n;
            }
        }
        return inc;
    }
}
