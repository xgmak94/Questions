/* https://leetcode.com/problems/maximum-subarray

Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
*/

class Solution {
    public int maxSubArray(int[] nums) {
        int[] memo = new int[nums.length];
        int max = memo[0] = nums[0];
             
        for(int i = 1 ; i < nums.length ; i++) {
            memo[i] = Math.max(memo[i-1] + nums[i], nums[i]);
            
            max = Math.max(max, memo[i]);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int maxEndingHere = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            maxEndingHere += nums[i];
            
            if(maxEndingHere > maxSum)
                maxSum = maxEndingHere;
            
            if(maxEndingHere < 0)
                maxEndingHere = 0;
        }
        return maxSum;
    }
}
