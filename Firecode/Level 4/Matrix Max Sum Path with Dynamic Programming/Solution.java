/*
Given an m x n matrix filled with non-negative integers, use dynamic programming techniques to find the maximum sum along a path from the top-left of the grid to the bottom-right. Return this maximum sum. The direction of movement is limited to right and down.

Example:
Input Matrix : 
             
    1 2 3
    4 5 6
    7 8 9

Output  : 1 + 4 + 7 + 8 + 9 = 29
*/

public static int matrixMaxSumDP(int[][] grid) {
    if(grid == null || grid.length == 0) 
        return 0;
    
    int m = grid.length, n = grid[0].length;
    int[][] memo = new int[m][n];
    memo[0][0] = grid[0][0];
    
    //prefill first column
    for(int i = 1 ; i < m ; i++) {
        memo[i][0] = memo[i - 1][0] + grid[i][0];
    }
    //prefill first row
    for(int j = 1 ; j < n ; j++) {
        memo[0][j] = memo[0][j - 1] + grid[0][j];
    }
    
    for(int i = 1 ; i < m ; i++) {
        for(int j = 1 ; j < n ; j++) {
            memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]) + grid[i][j];
        }
    }
    return memo[m - 1][n - 1];
}