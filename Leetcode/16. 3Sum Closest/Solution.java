/* https://leetcode.com/problems/3sum-closest/

Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

For example, given array S = {-1 2 1 -4}, and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3) return -1; //need 3 elements
        
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[nums.length-1];
        
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == target) {
                    closest = sum;
                    break;
                }
                else if(sum < target) {
                    l++;
                }
                else {
                    r--;
                }
                
                if(Math.abs(sum - target) < Math.abs(closest - target))
                    closest = sum;
            }
        }
        return closest;
    }      
}
