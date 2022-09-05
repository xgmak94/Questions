/* https://leetcode.com/problems/number-of-islands/

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

/**
 * @param {character[][]} grid
 * @return {number}
 */
var numIslands = function(grid) {
    function dfs(r, c) {
        let dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]];
        
        grid[r][c] = 0;
        dirs.forEach((dir) => {
            let dr = r+dir[0];
            let dc = c+dir[1];
            if(dr >= 0 && dr < m && dc >= 0 && dc < n && grid[dr][dc] === '1') {
                dfs(dr, dc);
            }
        })
    }
    
    let count = 0;
    let m = grid.length;
    let n = grid[0].length;
    
    for(let r = 0 ; r < m ; r++) {
        for(let c = 0 ; c < n ; c++) {
            if(grid[r][c] === '1') {
                count++;
                dfs(r, c);
            }
        }
    }
    return count;
};
