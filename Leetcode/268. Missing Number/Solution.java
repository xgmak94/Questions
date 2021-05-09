/* https://leetcode.com/problems/missing-number

Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
*/

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int sum0toN = n; // n + 0+1+2
        int actualSum = 0; //0 + num[0]+num[1]+num[2]

        for(int i = 0 ; i < n ; i++) {
            sum0toN += i;
            actualSum += nums[i];
        }
        return sum0toN - actualSum;
    }
}

class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] != i)
                return i;
        }
        return nums.length;
    }
}
