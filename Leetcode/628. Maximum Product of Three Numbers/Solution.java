/* https://leetcode.com/problems/maximum-product-of-three-numbers

Given an integer array, find three numbers whose product is maximum and output the maximum product.
*/

public class Solution {
    public int maximumProduct(int[] nums) {
        int prod = Integer.MIN_VALUE;
        Arrays.sort(nums);
        
        int max1 = nums[nums.length - 1];
        int max2 = nums[nums.length - 2];
        int max3 = nums[nums.length - 3];
        
        int min1 = nums[0];
        int min2 = nums[1];
        
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
