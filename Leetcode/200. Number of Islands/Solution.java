/* https://leetcode.com/problems/number-of-islands/description/

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3

*/

class Solution {
    public int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        
        for(int r = 0 ; r < m ; r++) {
            for(int c = 0 ; c < n ; c++) {
                if(grid[r][c] == '1') {
                    count++;
                    dfs(grid, r, c, m, n);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][]grid, int r, int c, int m, int n) {
        if(r < 0 || r >= m || c < 0 || c >= n) { //out of bounds
            return;
        }
        
        for(int[] dir : dirs) {
            int dr = r + dir[0];
            int dc = c + dir[1];
            
            if(dr >= 0 && dr < m && dc >= 0 && dc < n && grid[dr][dc] == '1') { //if part of the original island it has already been counted and we can 0 it out
                grid[dr][dc] = '0';
                dfs(grid, dr, dc, m, n);
            }
        }
    }
}
