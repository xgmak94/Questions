/* https://leetcode.com/problems/spiral-matrix-ii/description/

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        
        int rowBegin = 0;
        int rowEnd = n - 1;
        
        int colBegin = 0;
        int colEnd = n - 1;
        
        int num = 1;
        while(colBegin <= colEnd && rowBegin <= rowEnd) {//right down left up repeat
            //right
            for(int i = colBegin ; i <= colEnd ; i++) {
                matrix[rowBegin][i] = num;
                num++;
            }
            rowBegin++;

            //down
            for(int i = rowBegin ; i <= rowEnd ; i++) {
                matrix[i][colEnd] = num;
                num++;
            }
            colEnd--;

            //left
            if(rowBegin <= rowEnd) {
	            for(int i = colEnd ; i >= colBegin ; i--) {
                    matrix[rowEnd][i] = num;
                    num++;
	            }
	            rowEnd--;
            }
            
            //up
            if(colBegin <= colEnd) {
	            for(int i = rowEnd ; i >= rowBegin ; i--) {
                    matrix[i][colBegin] = num;
                    num++;
	            }
	            colBegin++;
            }
        }
        return matrix;
    }
}
