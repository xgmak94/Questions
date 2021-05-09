/* https://leetcode.com/problems/01-matrix/

Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
The distance between two adjacent cells is 1.

Example 1:
Input:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Output:
[[0,0,0],
 [0,1,0],
 [0,0,0]]

Example 2:
Input:
[[0,0,0],
 [0,1,0],
 [1,1,1]]

Output:
[[0,0,0],
 [0,1,0],
 [1,2,1]]
 
Note:
The number of elements of the given matrix will not exceed 10,000.
There are at least one 0 in the given matrix.
The cells are adjacent in only four directions: up, down, left and right.
*/

class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(matrix[i][j] == 0) q.offer(new int[]{i,j});
                else matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        
        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            for (int[] d : dirs) {
                int dr = r + d[0];
                int dc = c + d[1];
                if (dr < 0 || dr >= m || dc < 0 || dc >= n || //in bounds
                	matrix[dr][dc] <= matrix[r][c] + 1) continue;
                
                q.add(new int[] {dr, dc});
                matrix[dr][dc] = matrix[r][c] + 1;
            }
        }
        return matrix;
    }
}
