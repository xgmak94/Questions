/* https://leetcode.com/problems/minimum-moves-to-equal-array-elements/description/

Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.

Example:

Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
*/

class Solution {
    public int minMoves(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int length = nums.length;
        int sum = 0;
        int min = nums[0];
        
        for(int i = 0 ; i < length ; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }
        return sum - (min*length);
    }
}
