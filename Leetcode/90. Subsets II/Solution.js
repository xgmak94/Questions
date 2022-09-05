/* https://leetcode.com/problems/subsets-ii/

Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:
Input: nums = [0]
Output: [[],[0]]

Constraints:
1 <= nums.length <= 10
-10 <= nums[i] <= 10
*/

/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    nums.sort();
    let list = [];
    function backtrack(curr, idx) {
        list.push(curr);
        for(let i = idx ; i < nums.length ; i++) {
            if(i > idx && nums[i] === nums[i-1]) continue;
            
            curr.push(nums[i]);
            backtrack(curr.slice(), i+1);
            curr.pop();
        }
    }
    backtrack([], 0);
    return list;
};
