/*
You are given an m x n 2D image matrix where each integer represents a pixel. Flip it in-place along its horizontal axis.

Input image :  
              1 1
              0 0 
Modified to :   
              0 0
              1 1
              
*/

public static void flipHorizontalAxis(int[][] matrix) {
    int r = matrix.length - 1, c = matrix[0].length - 1;
    int temp = 0;
    for(int i = 0; i <= r/2; i++){
        for(int j = 0; j <= c; j++){
            temp = matrix[i][j];
            matrix[i][j] = matrix[r-i][j];
            matrix[r-i][j] = temp;
        }
    }
}