/* https://leetcode.com/problems/subsets/

Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        
        backtrack(all, new ArrayList<>(), nums, 0);
        
        return all;
    }
    public void backtrack(List<List<Integer>> allSets, List<Integer> set, int[] nums, int idx) {
        allSets.add(new ArrayList<>(set));
        for(int i = idx ; i < nums.length ; i++) {
            set.add(nums[i]);
            backtrack(allSets, set, nums, i+1);
            set.remove(set.size() - 1); //remove this
        }
    }
}
