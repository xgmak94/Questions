/* https://leetcode.com/problems/majority-element-ii/

Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
The algorithm should run in linear time and in O(1) space.

*/

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
            
            if(map.get(n) > (nums.length / 3) && !list.contains(n)) {
                list.add(n);
            }
        }
        return list;
    }
}
