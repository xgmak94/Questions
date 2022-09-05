/* https://leetcode.com/problems/max-area-of-island/

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.

Example 1:
Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.

Example 2:
Input: grid = [[0,0,0,0,0,0,0,0]]
Output: 0

Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 50
grid[i][j] is either 0 or 1.
*/

/**
 * @param {number[][]} grid
 * @return {number}
 */
var maxAreaOfIsland = function(grid) {
    function dfs(r, c) {
        let dirs = [[0, -1], [0, 1], [-1, 0], [1, 0]];
        
        grid[r][c] = 0;
        area++;
        maxArea = Math.max(area, maxArea);
        dirs.forEach((dir) => {
            let dr = r+dir[0];
            let dc = c+dir[1];
            if(dr >= 0 && dr < m && dc >= 0 && dc < n && grid[dr][dc] === 1) {
                dfs(dr, dc);
            }
        })
    }
    
    let maxArea = 0;
    let area = 0;
    let m = grid.length;
    let n = grid[0].length;
    
    for(let r = 0 ; r < m ; r++) {
        for(let c = 0 ; c < n ; c++) {
            if(grid[r][c] === 1) {
                area = 0;
                dfs(r, c);
            }
        }
    }
    return maxArea;
};
