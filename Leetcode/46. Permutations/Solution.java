/* https://leetcode.com/problems/permutations/description/

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        
        backtrack(permutations, new ArrayList<>(), nums);
        return permutations;
    }
    
    public void backtrack(List<List<Integer>> permutations, List<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            permutations.add(new ArrayList<>(list));
        }
        else {
            for(int i = 0; i < nums.length; i++){ 
                 if(list.contains(nums[i])) 
                     continue; // element already exists, skip
                
                 list.add(nums[i]);
                 backtrack(permutations, list, nums);
                 list.remove(list.size() - 1);
            }
        }
    }
}
