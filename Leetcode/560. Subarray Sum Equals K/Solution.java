/* https://leetcode.com/problems/subarray-sum-equals-k/description/

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++) { //subarray starts at i
            int sum = 0;
            for(int j = i ; j < nums.length ; j++) { //subarray ends at j
                sum += nums[j];
                if(sum == k)
                    count++;
            }
        }
        return count;
    }
}
