/* https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

Given an unsorted array of integers, find the length of longest continuous increasing subsequence.

Example 1:
Input: [1,3,5,4,7]
Output: 3
Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3. 
Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4. 

Example 2:
Input: [2,2,2,2,2]
Output: 1
Explanation: The longest continuous increasing subsequence is [2], its length is 1.
*/

class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        
        int maxLength = 1;
        
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] > nums[i-1]) {
                memo[i] = memo[i-1] + 1;
                
                maxLength = Math.max(memo[i], maxLength);
            }
        }
        return maxLength;
    }
}
