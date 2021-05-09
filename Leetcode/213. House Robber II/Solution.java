/* https://leetcode.com/problems/house-robber-ii/

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. 
This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. 
Meanwhile, the security system for these houses remain the same as for those in the previous street.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        
        int max1 = help(nums, 0, nums.length - 2);
        int max2 = help(nums, 1, nums.length - 1);
        
        return Math.max(max1, max2);
    }
    
    public int help(int[] nums, int n, int m) {
        if(n == m)
            return nums[n];
        
        int[] memo = new int[nums.length];
        memo[n] = nums[n];
        memo[n + 1] = Math.max(nums[n], nums[n+1]);
        
        for(int i = n + 2 ; i <= m ; i++) {
            memo[i] = Math.max(memo[i-2] + nums[i], memo[i-1]);
        }
        return memo[m];
    }
        
}
