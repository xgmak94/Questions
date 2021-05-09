/* https://leetcode.com/problems/shortest-unsorted-continuous-subarray/description/

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

Example 1:
Input: [2, 6, 4, 8, 10, 9, 15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
*/

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        
        int start = nums.length;
        int end = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] != sorted[i]) {
                start = Math.min(start, i); //first index that is not correct
                end = Math.max(end, i); //last index that is not correct
            }
        }
        if(end - start >= 0) {
        	return end - start + 1;
        }
        else {
        	return 0;
        }
    }
}
