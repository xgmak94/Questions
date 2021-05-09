/* https://leetcode.com/problems/container-with-most-water/description/

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
*/

class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;
        
        while(l < r) {
            int area = (r-l) * Math.min(height[l], height[r]);
            maxArea = Math.max(area, maxArea);
            
            if(height[l] < height[r]) {
                l++;
            }
            else {
                r--;
            }
        }
        return maxArea;
    }
}
