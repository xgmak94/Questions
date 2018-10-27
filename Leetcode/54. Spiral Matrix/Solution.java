/* https://leetcode.com/problems/spiral-matrix/discuss/

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        if(matrix.length == 0 || matrix[0].length == 0)
            return list;
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        int rowBegin = 0;
        int rowEnd = r - 1;
        
        int colBegin = 0;
        int colEnd = c - 1;
        
        while(colBegin <= colEnd && rowBegin <= rowEnd) { //right down left up repeat      
            //right
            for(int i = colBegin ; i <= colEnd ; i++) {
                list.add(matrix[rowBegin][i]);
            }
            rowBegin++;

            //down
            for(int i = rowBegin ; i <= rowEnd ; i++) {
                list.add(matrix[i][colEnd]);
            }
            colEnd--;

            //left
            if(rowBegin <= rowEnd) {
	            for(int i = colEnd ; i >= colBegin ; i--) {
	                list.add(matrix[rowEnd][i]);
	            }
                rowEnd--;
            }
            
            //up
            if(colBegin <= colEnd) {
	            for(int i = rowEnd ; i >= rowBegin ; i--) {
	                list.add(matrix[i][colBegin]);
	            }
                colBegin++;
	        }          
        }
        return list;
    }
}
