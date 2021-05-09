/* https://leetcode.com/problems/combinations/

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n, k, 1);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int n, int k, int start) {
        if(tempList.size() == k) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        else {
            for(int i = start ; i <= n ; i++) {
                tempList.add(i);
                backtrack(list, tempList, n, k, i+1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
