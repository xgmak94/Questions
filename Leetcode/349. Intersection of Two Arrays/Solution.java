/* https://leetcode.com/problems/intersection-of-two-arrays

Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>(); //guarantees us unique elements

        for(int n : nums1) {
            set.add(n);
        }
        
        for(int m : nums2) {
            if(set.contains(m)) {
                intersect.add(m);
            }
        }
        return intersect.stream().mapToInt(i->i).toArray();
    }
}

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
    	int length1 = nums1.length;
    	int length2 = nums2.length;
        if(length1 < 1 || length2 < 1)
            return new int[0];
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Set<Integer> set = new HashSet<>();
        for(int i : nums1)
            set.add(i);
        
        for(int i : nums2) {
            if(set.contains(i)) {
                if(!list.contains(i))
                    list.add(i);
            }
        }
        
        int[] arr = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++)
            arr[i] = list.get(i);
        
        return arr;
    }
}
