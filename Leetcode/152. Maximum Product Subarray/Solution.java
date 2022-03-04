/* https://leetcode.com/problems/maximum-product-subarray/

Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

Example 1:
Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
*/

class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = nums[0]; //store the max + value
        int min = nums[0]; //store the min - value
        
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] < 0) {//negative number we swap the min and max
                int temp = min;
                min = max;
                max = temp;
            }
            
            max = Math.max(nums[i], max*nums[i]);
            min = Math.min(nums[i], min*nums[i]);
            
            res = Math.max(res, max);
        }
        return res;
    }
}
