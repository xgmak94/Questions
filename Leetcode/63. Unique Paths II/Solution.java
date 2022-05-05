/* https://leetcode.com/problems/unique-paths-ii/

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.
*/

//same as 62. Unique Paths, add in obstacles that are 0 ways to get to
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(m == 0 || n == 0 || obstacleGrid[0][0] == 1) return 0;
        
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        
        for(int i = 1 ; i < m ; i++) {
            if(dp[i-1][0] == 0 || obstacleGrid[i][0] == 1) { //if there is/was an obstacle
                dp[i][0] = 0;
            }
            else {
                dp[i][0] = 1;
            }
        }
        
        for(int j = 1 ; j < n ; j++) {
            if(dp[0][j-1] == 0 || obstacleGrid[0][j] == 1) { //if there is/was an obstacle
                dp[0][j] = 0;
            }
            else {
                dp[0][j] = 1;
            }
        }
        
        for(int i = 1 ; i < m ; i++) {
            for(int j = 1 ; j < n ; j++) {
                if(obstacleGrid[i][j] == 1) { //if there is an obstacle
                    dp[i][j] = 0;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0][0] == 1)
            return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
                
        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        
        for(int i = 1 ; i < m ; i++)
            memo[i][0] = (obstacleGrid[i][0] == 1) ? 0 : memo[i - 1][0];
        for(int j = 1 ; j < n ; j++)
            memo[0][j] = (obstacleGrid[0][j] == 1) ? 0 : memo[0][j - 1];
        
        
        for(int i = 1 ; i < m ; i++) {
            for(int j = 1 ; j < n ; j++) {
                if(obstacleGrid[i][j] == 1)
                    memo[i][j] = 0;
                else
                    memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }
        return memo[m - 1][n - 1];
    }
}
