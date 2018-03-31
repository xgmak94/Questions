/* https://leetcode.com/problems/trapping-rain-water/description/
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

*/

class Solution {
    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        
        int length = height.length;
        int water = 0;
        
        int maxLeft = 0;
        int maxRight = 0;

        int[] right = new int[length];
        for(int i = length - 1 ; i >= 0 ; i--) {
            if(height[i] > maxRight) {
                maxRight = height[i];
            }
            right[i] = maxRight;
        }
        
        for(int i = 0 ; i < length ; i++) {
            water += Math.max((Math.min(maxLeft, right[i]) - height[i]), 0);
            if(height[i] > maxLeft) {
                maxLeft = height[i];
            }
        }
        
        return water;
    }
}
