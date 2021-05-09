/* https://leetcode.com/problems/combination-sum-iii/

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), k, n, 1);
        return list;
    }
    
    public void backtrack(List<List<Integer>> list, List<Integer> temp, int k, int n, int start) {
        if(n == 0 && temp.size() == k) {
            list.add(new ArrayList<>(temp));
        }
        else {
            for(int i = start ; i <= 9 ; i++) {
                temp.add(i);        
                backtrack(list, temp, k, n - i, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
