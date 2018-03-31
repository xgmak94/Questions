/* https://leetcode.com/problems/range-sum-query-immutable/description/

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

*/

public class NumArray {
    int[] arr;
    int[] sum;
    
    public NumArray(int[] nums) {
        if(nums.length < 1)
            return;
        arr = new int[nums.length];
        sum = new int[nums.length];
        arr[0] = sum[0] = nums[0];
        
        for(int i = 1 ; i < nums.length ; i++) {
            arr[i] = nums[i];
            sum[i] = sum[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
    	return (i == 0) ? sum[j] : sum[j] - sum[i - 1];
    }
}

