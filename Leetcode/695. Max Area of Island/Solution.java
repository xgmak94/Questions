/* https://leetcode.com/problems/max-area-of-island/description/

Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

Find the maximum area of an island in the given 2D array. (If there is no island, the maximum area is 0.)

Example 1:
[[0,0,1,0,0,0,0,1,0,0,0,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,1,1,0,1,0,0,0,0,0,0,0,0],
 [0,1,0,0,1,1,0,0,1,0,1,0,0],
 [0,1,0,0,1,1,0,0,1,1,1,0,0],
 [0,0,0,0,0,0,0,0,0,0,1,0,0],
 [0,0,0,0,0,0,0,1,1,1,0,0,0],
 [0,0,0,0,0,0,0,1,1,0,0,0,0]]
Given the above grid, return 6. Note the answer is not 11, because the island must be connected 4-directionally.
Example 2:
[[0,0,0,0,0,0,0,0]]
Given the above grid, return 0.
Note: The length of each dimension in the given grid does not exceed 50.

*/
class Solution {
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    // up down left right to search for more groups
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 | grid[0].length == 0)
            return 0;
        
        int maxIsland = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 1) {
                    int island = dfs(grid, i, j, m, n);
                    maxIsland = Math.max(island, maxIsland);
                }
            }
        }
        return maxIsland;
    }
    
    public int dfs(int[][] grid, int r, int c, int m, int n) {
        if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)
            return 0;
        
        grid[r][c] = 0;
        
        int island = 1; // count itself
        
        for(int[] dir : dirs) {
            int dr = r + dir[0];
            int dc = c + dir[1];
            
            island += dfs(grid, dr, dc, m, n);
        }
        
        return island;
    }
}

class Solution {
    private static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    //up, down, left, right

    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0)
            return 0;
        
        int maxArea = 0;
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }
    
    public int dfs(int[][] grid, int m, int n) {
        if(grid[m][n] == 0)
            return 0;
        
        int area = 1;
        grid[m][n] = 0; // set to 0 so we do not count it again
        
        for(int[] dir : dirs) {
            int dx = m + dir[0];
            int dy = n + dir[1];
            
            if(dx >= 0 && dx < grid.length && dy >= 0 && dy < grid[0].length) {
                area += dfs(grid, dx, dy);
            }
        }
        return area;
    }
}
