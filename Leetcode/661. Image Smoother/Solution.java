/* https://leetcode.com/problems/image-smoother/description/

Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
*/

class Solution {        
    int[][] dirs = new int[][]{{-1,-1},{-1,0},{-1,1},  
                                {0,-1},{0, 0},{0,1},  
                                {1,-1},{1,0},{1, 1}};
    public int[][] imageSmoother(int[][] M) {
        
        int m = M.length;
        int n = M[0].length;
        int[][] smooth = new int[m][n];
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                smooth[i][j] = smoothed(M, i, j, m, n);
            }
        }
        return smooth;
    }
    
    public int smoothed(int[][] M, int r, int c, int m, int n) {
        int sum = 0;
        int numDirs = 0;
        for(int[] dir : dirs) {
            int dr = r + dir[0];
            int dc = c + dir[1];
    
            if(dr >= 0 && dr < m && dc >= 0 && dc < n) { //if not off the image
                sum += M[dr][dc];
                numDirs++;
            }
        }
        return sum / numDirs;
    }
}
