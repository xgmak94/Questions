/* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.
The array may contain duplicates.

Example 1:
Input: [1,3,5]
Output: 1

Example 2:
Input: [2,2,2,0,1]
Output: 0
*/

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == null) return -1;

        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] < nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }
}
