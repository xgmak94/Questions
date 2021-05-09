/* https://leetcode.com/problems/contains-duplicate-ii

Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the absolute difference between i and j is at most k.
*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < nums.length ; i++) { // sliding window
            if(i > k) { //start removing after first k
                set.remove(nums[i - k - 1]);
            }
            
            if(!set.contains(nums[i])) { //no nearby duplicate
                set.add(nums[i]);
            }
            else { //nearby duplicate
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // (value, idx)
        
        for(int i = 0 ; i < nums.length ; i++) {
            int num = nums[i];
            if(map.containsKey(num)) {
                if(i <= map.get(num) + k) { //if curr idx <= last idx + k
                    return true;
                }
            }
            map.put(num, i);
        }
        return false;
    }
}
