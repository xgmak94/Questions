/* https://leetcode.com/problems/continuous-subarray-sum/

Given an integer array nums and an integer k, return true if nums has a continuous subarray of size at least two whose elements sum up to a multiple of k, or false otherwise.

An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
Example 1:
Input: [23, 2, 4, 6, 7],  k=6
Output: True
Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.

Example 2:
Input: [23, 2, 6, 4, 7],  k=6
Output: True
Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
*/

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            int sum = nums[i];
            for(int j = i + 1 ; j < nums.length ; j++) {
                sum += nums[j];
                if(k == 0 && sum == 0) return true; //special case
                if(k != 0 && sum % k == 0) return true;
            }
        }
        return false;
    }
}
