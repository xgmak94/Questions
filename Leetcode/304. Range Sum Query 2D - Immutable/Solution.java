/* https://leetcode.com/problems/range-sum-query-2d-immutable/description/

Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

*/

class NumMatrix {
    int[][] mat;
    int[][] sum;
    
    public NumMatrix(int[][] matrix) {     
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;   
        }
        int m = matrix.length;
        int n = matrix[0].length;
    
        mat = new int[m][n];
        sum = new int[m][n];
        
        mat[0][0] = sum[0][0] = matrix[0][0];
        for(int i = 1 ; i < n ; i++) {
            mat[0][i] = matrix[0][i];
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }
        
        for(int i = 1 ; i < m ; i++) {
            mat[i][0] = matrix[i][0];
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        
        for(int i = 1 ; i < n ; i++) {
            for(int j = 1 ; j < m ; j++) {
                mat[i][j] = matrix[i][j];
                sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum [i - 1][j - 1] + matrix[i][j];
            }
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int ret = sum[row2][col2];
        
        if(col1 - 1 >= 0)
            ret -= sum[row2][col1 - 1];
        
        if(row1 - 1 >= 0)
            ret -= sum[row1 - 1][col2];
        
        if(col1 - 1 >= 0 && row1 - 1 >= 0)
            ret += sum[row1 - 1][col1 - 1];
        
        return ret;
    }
}
