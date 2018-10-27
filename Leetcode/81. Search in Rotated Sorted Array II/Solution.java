/* https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/

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
        if(nums.length == 0)
            return false;
        if(nums.length == 1)
            return (nums[0] == target) ? true : false;
                    
        int i = 0;
        
        if(target < nums[0]) {
            i++;
            while(i < nums.length && nums[i] > nums[i - 1]) {
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