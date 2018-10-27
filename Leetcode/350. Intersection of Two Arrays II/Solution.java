/* https://leetcode.com/problems/intersection-of-two-arrays-ii
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
The result can be in any order.
*/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1); //frequency of elements in nums1
        }
        
        for(int m : nums2) {
            if(map.containsKey(m) && map.get(m) > 0) {
                list.add(m);
                map.put(m, map.getOrDefault(m, 0) - 1); //subtract 1 from frequency and add to intersection
            }
            
        }
        
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	int length1 = nums1.length;
    	int length2 = nums2.length;
        if(length1 < 1 || length2 < 1)
            return new int[0];
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            if(map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        
        for(int i : nums2) {
            if(map.containsKey(i)) {
                list.add(i);
                if(map.get(i) == 1) {
                    map.remove(i);
                }
                else {
                    map.put(i, map.get(i) - 1);
                }
            }
        }
        
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++)
            arr[i] = list.get(i);
        
        return arr;
    }
}
