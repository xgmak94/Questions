/* https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

A subarray is a contiguous subsequence of the array.

Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

Constraints:
1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
*/

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    let max = nums[0];
    let dp = new Array(nums.length);
    for(let i = 0 ; i < nums.length ; i++) {
        dp[i] = [];
    }
    dp[0] = [nums[0], nums[0]];
    
    for(let i = 1 ; i < nums.length ; i++) {
        dp[i][0] = Math.max(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i], nums[i]);
        dp[i][1] = Math.min(dp[i-1][0] * nums[i], dp[i-1][1] * nums[i], nums[i]);
        max = Math.max(max, dp[i][0]);
    }
    return max;
};
