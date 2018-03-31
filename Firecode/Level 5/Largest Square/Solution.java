/*

Given a two dimensional matrix made up of 0's and 1's, find the largest square containing all 1's and return its 'area'. The 'area' is simply the sum of all integers enclosed in the square.
Example:

Input Matrix : 
             
  1101
  1101
  1111 

Output  : 4

*/

public static int largestSquare(char[][] matrix) {
    
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
      return 0;
   
    int m = matrix.length;
    int n = matrix[0].length;
   
    int[][] t = new int[m][n];
   
    //top row
    for (int i = 0; i < m; i++) {
      t[i][0] = Character.getNumericValue(matrix[i][0]);
    }
   
    //left column
    for (int j = 0; j < n; j++) {
      t[0][j] = Character.getNumericValue(matrix[0][j]);
    }
   
    //cells inside
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        if (matrix[i][j] == '1') {
          int min = Math.min(t[i - 1][j], t[i - 1][j - 1]);
          min = Math.min(min,t[i][j - 1]);
          t[i][j] = min + 1;
        } else {
          t[i][j] = 0;
        }
      }
    }
   
    int max = 0;
    //get maximal length
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (t[i][j] > max) {
          max = t[i][j];
        }
      }
    }
   
    return max * max;
    
}