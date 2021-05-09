/* https://leetcode.com/problems/search-in-rotated-sorted-array

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }
                    
        int i = 0;
        
        if(target < nums[0]) {
            i++;
            while(i < nums.length && nums[i] > nums[i - 1]) {
                i++;
            }
        }
        
       	while(i < nums.length) {
            if(target == nums[i]) {
                return i;
            }
            i++;
        }
        return -1;
    }
}

class Solution {
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
 