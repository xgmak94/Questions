/* https://leetcode.com/problems/subsets-ii/

Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> all = new ArrayList<>();
        
        Arrays.sort(nums);
        backtrack(all, new ArrayList<>(), nums, 0);
        
        return all;
    }
    
    public void backtrack(List<List<Integer>> allSets, List<Integer> set, int[] nums, int idx) {
        allSets.add(new ArrayList<>(set));
        for(int i = idx ; i < nums.length ; i++) {
            if(i > idx && nums[i] == nums[i-1]) continue;

            set.add(nums[i]);
            backtrack(allSets, set, nums, i+1);
            set.remove(set.size() - 1);
        }
    }
}
