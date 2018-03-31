/* https://leetcode.com/problems/longest-increasing-subsequence/description/

Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?

*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);       
        int max = 1;
        
        for(int i = 1 ; i < nums.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                    if(memo[i] > max)
                        max = memo[i];
                }
            }
        }
        return max;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        
        for(int i = 1 ; i < nums.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        
        int max = memo[0];
        for(int i = 1 ; i < nums.length ; i++) {
            max = Math.max(max, memo[i]);
        }
        return max;
    }
}