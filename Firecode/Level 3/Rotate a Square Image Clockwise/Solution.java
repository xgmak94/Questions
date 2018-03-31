/*
You are given a square 2D image matrix where each integer represents a pixel. 
Write a method rotateSquareImageCW to rotate the image clockwise - in-place. 
This problem can be broken down into simpler sub-problems you've already solved earlier! 
Rotating an image clockwise can be achieved by taking the transpose of the image matrix and then flipping it on its vertical axis.

Example:Input image :
1 0
1 0 
Modified to :
1 1
0 0

*/

public static void rotateSquareImageCW(int[][] matrix) {
    transposeMatrix(matrix);
    flipVerticalAxis(matrix);
}   


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


private static void flipVerticalAxis(int[][] matrix) {
    int n = matrix.length - 1;
    int temp = 0;
    for(int i = 0; i <= n; i++){
        for(int j = 0; j <= n/2; j++){
            temp = matrix[i][j];
            matrix[i][j] = matrix[i][n-j];
            matrix[i][n-j] = temp;
        }
    }
}