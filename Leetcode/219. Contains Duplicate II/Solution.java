/* https://leetcode.com/problems/contains-duplicate-ii

Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the absolute difference between i and j is at most k.

*/

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            int num = nums[i];
            if(map.containsKey(num)) {
                if(i <= map.get(num) + k) {
                    return true;
                }
            }
            map.put(num, i);
        }
        return false;
    }
}

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int length = nums.length;
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(i > k)
                set.remove(nums[i - k - 1]);
            
            if(!set.contains(nums[i]))
                set.add(nums[i]);
            else
                return true;
        }
        return false;
    }
}
