/* https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[2];
        ret[0] = ret[1] = -1;
        if(nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) //not found if length is 0 or first num is greater than target or last number is less than target
        	return ret;

        boolean found = false;

        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == target) {
                if(found) { //not first instance of target
                	ret[1] = i;
                }
                else { //first instance of target
                    ret[0] = i;
                    ret[1] = i;
                    found = true;
                }
            }
            else if(nums[i] > target)
                break;
        }
        return ret;
    }
}
