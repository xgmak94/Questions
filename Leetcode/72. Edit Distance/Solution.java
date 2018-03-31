/* https://leetcode.com/problems/edit-distance

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character


*/

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] memo = new int[m+1][n+1];

        for(int i = 0 ; i < m+1 ; i++)
        	memo[i][0] = i;
        for(int j = 0 ; j < n+1 ; j++)
        	memo[0][j] = j;

        for(int i = 1 ; i < m+1 ; i++) {
        	for(int j = 1 ; j < n+1 ; j++) {
        		if(word1.charAt(i-1) == word2.charAt(j-1))
        			memo[i][j] = memo[i-1][j-1];
        		else
        			memo[i][j] = Math.min(memo[i-1][j-1] + 1, Math.min(memo[i-1][j] + 1, memo[i][j-1] + 1));
        	}
        }
        return memo[m][n];
    }
}
