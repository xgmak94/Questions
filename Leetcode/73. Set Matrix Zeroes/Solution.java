/* https://leetcode.com/problems/set-matrix-zeroes

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

*/

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        boolean firstRow = false;
        boolean firstCol = false;
        for(int i = 0 ; i < r ; i++) {
            for(int j = 0 ; j < c ; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) firstRow = true;
                    if(j == 0) firstCol = true;
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = 1 ; i < r ; i++) {
            for(int j = 1 ; j < c ; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(firstRow) {
            for(int j = 0 ; j < c ; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstCol) {
            for(int i = 0 ; i < r ; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return;

        int m = matrix.length;
        int n = matrix[0].length;
        
        int[] rows = new int[m];
        int[] cols = new int[n];
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(matrix[i][j] == 0) {
                    rows[i] = 1;
                    cols[j] = 1;
                }
            }
        }
        
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(rows[i] == 1 || cols[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}