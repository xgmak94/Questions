/* https://leetcode.com/problems/largest-perimeter-triangle/

Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.

If it is impossible to form any triangle of non-zero area, return 0.

Example 1:
Input: [2,1,2]
Output: 5

Example 2:
Input: [1,2,1]
Output: 0

Example 3:
Input: [3,2,3,4]
Output: 10

Example 4:
Input: [3,6,2,3]
Output: 8
*/

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length - 1 ; i >= 2 ; i--) {
            if(nums[i-2] + nums[i-1] > nums[i])
                return nums[i-2]+nums[i-1]+nums[i];
        }
        return 0;
    }
}
