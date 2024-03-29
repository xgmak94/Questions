/* https://leetcode.com/problems/intersection-of-two-arrays-ii
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:
Each element in the result should appear as many times as it shows in both arrays.
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

class Solution {
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
