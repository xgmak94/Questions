/*
You are given a square 2D image matrix where each integer represents a pixel. 
Write a method transposeMatrix to transform the matrix into its Transpose - in-place. 

Example:Input image :
1 0
1 0 
Modified to :
1 1
0 0
*/

public static void transposeMatrix(int[][] matrix) {
    int n = matrix.length - 1;
    int temp = 0;
    for(int i = 0; i <= n; i++){
        for(int j = i+1; j <= n; j++){
            temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
}