/* https://leetcode.com/problems/3sum-closest/description/

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3)
            return -1
        
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if(sum > target)
                    k--;
                else
                    j++;
                
                if(Math.abs(sum - target) < Math.abs(res - target))
                    res = sum;
            }
        }
        return res;
    }      
}
