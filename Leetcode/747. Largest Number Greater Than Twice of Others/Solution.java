/* https://leetcode.com/problems/largest-number-greater-than-twice-of-others/description/
747. Largest Number Greater Than Twice of Others

In a given integer array nums, there is always exactly one largest element.

Find whether the largest element in the array is at least twice as much as every other number in the array.

If it is, return the index of the largest element, otherwise return -1.

Example 1:
Input: nums = [3, 6, 1, 0]
Output: 1
Explanation: 6 is the largest integer, and for every other number in the array x,
6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
Example 2:
Input: nums = [1, 2, 3, 4]
Output: -1
Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.

*/

class Solution {
    public int dominantIndex(int[] nums) {
        int idx = 0;
        int firstNum = 0;
        int secondNum = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] > firstNum) {
                secondNum = firstNum;
                firstNum = nums[i];
                idx = i;
            }
            else if(nums[i] > secondNum) {
                secondNum = nums[i];
            }
        }      
        return(firstNum >= 2*secondNum) ? idx : -1;
    }
}
