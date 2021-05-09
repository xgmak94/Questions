/*
You are given a square 2D image matrix where each integer represents a pixel. 
Write a method rotateSquareImageCCW to rotate the image counterclockwise - in-place. 
This problem can be broken down into simpler sub-problems you've already solved earlier! 
Rotating an image counterclockwise can be achieved by taking the transpose of the image matrix and then flipping it on its horizontal axis.
*/

public static void rotateSquareImageCCW(int[][] matrix) {
    transposeMatrix(matrix);
    flipItHorizontalAxis(matrix);
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


private static void flipItHorizontalAxis(int[][] matrix) {
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