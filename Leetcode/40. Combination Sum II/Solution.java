/* https://leetcode.com/problems/combination-sum-ii/

Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

Example 2:
Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(new HashSet<>(), list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    
    public void backtrack(Set<List<Integer>> set, List<List<Integer>> list, List<Integer> tempList, int[] candidates, int target, int idx) {
        if(target < 0) {
            return;
        }
        else if(target == 0 && !set.contains(new ArrayList<>(tempList))) {
            set.add(new ArrayList<>(tempList));
            list.add(new ArrayList<>(tempList));
            return;
        }
        else {
            for(int i = idx ; i < candidates.length ; i++) {
                tempList.add(candidates[i]);
                backtrack(set, list, tempList, candidates, target-candidates[i], i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
