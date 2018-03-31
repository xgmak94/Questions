/* https://leetcode.com/problems/delete-operation-for-two-strings/description/

Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".

*/


class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[][] memo = new int[m + 1][n + 1];
        
        for(int i = 0 ; i < m+1 ; i++)
            memo[i][0] = i;
        for(int j = 0 ; j < n+1 ; j++)
            memo[0][j] = j;
        
        
        for(int i = 1 ; i < m+1 ; i++) {
            for(int j = 1 ; j < n+1 ; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    memo[i][j] = memo[i-1][j-1];
                }
                else {
                    memo[i][j] = Math.min(memo[i-1][j-1] + 2, Math.min(memo[i-1][j] + 1, memo[i][j-1] + 1));
                }
            }
        }
        return memo[m][n];
    }
}
