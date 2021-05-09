/* https://leetcode.com/problems/sort-colors/

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/

class Solution {
    public void sortColors(int[] nums) {
        int[] buckets = new int[3];
        
        for(int i : nums) { //counting sort
            buckets[i]++;
        }
        
        int idx = 0;
        while(idx < buckets[0]) { // 0's
            nums[idx] = 0;
            idx++;
        }
        while(idx < buckets[0] + buckets[1]) { //0's and 1's
            nums[idx] = 1;
            idx++;
        }
        while(idx < nums.length) { //the rest
            nums[idx] = 2;
            idx++;
        }
    }
}
