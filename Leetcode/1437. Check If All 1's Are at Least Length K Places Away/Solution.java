/* https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other, otherwise return False.

Example 1:
Input: nums = [1,0,0,0,1,0,0,1], k = 2
Output: true
Explanation: Each of the 1s are at least 2 places away from each other.

Example 2:
Input: nums = [1,0,0,1,0,1], k = 2
Output: false
Explanation: The second 1 and third 1 are only one apart from each other.

Example 3:
Input: nums = [1,1,1,1,1], k = 0
Output: true

Example 4:
Input: nums = [0,1,0,1], k = 1
Output: true
*/

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int lastOne = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == 1) {
                if(lastOne != Integer.MIN_VALUE && lastOne + k >= i) {
                    return false;
                }
                lastOne = i;
            }
        }
        return true;
    }
}

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == 1) 
            	list.add(i);
        }
        
        for(int i = 0 ; i < list.size() - 1 ; i++) {
            int idx1 = list.get(i);
            int idx2 = list.get(i+1);
            
            if(idx1+k >= idx2) {
                return false;
            }
        }
        return true;
    }
}
