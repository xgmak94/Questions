/* https://leetcode.com/problems/combination-sum-ii/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

Constraints:
1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30
*/

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    let list = [];
    candidates.sort();
    function backtrack(curr, sum, idx) {
        if(sum === target) {
            list.push(curr);
            return;
        }
        if(sum > target) {
            return;
        }
        for(let i = idx ; i < candidates.length ; i++) {
            if(i > idx && candidates[i] === candidates[i-1]) continue;
            curr.push(candidates[i]);
            backtrack(curr.slice(), sum + candidates[i], i+1);
            curr.pop();
        }
    }
    
    backtrack([], 0, 0);
    return list;
};
