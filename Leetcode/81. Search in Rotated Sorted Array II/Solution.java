/* https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
Input: nums = [2,5,6,0,0,1,2], target = 0
Output: true

Example 2:
Input: nums = [2,5,6,0,0,1,2], target = 3
Output: false
*/

public class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 0) {
            return false;
        }
                    
        int i = 0;
        if(target < nums[0]) {
            while(i+1 < nums.length && nums[i+1] > nums[i]) {
                i++;
            }
        }
        
        while(i < nums.length) {
            if(target == nums[i]) {
                return true;
            }
            i++;
        }
        return false;
    }
}
