/* https://leetcode.com/problems/matrix-block-sum/

Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.

Example 1:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
Output: [[12,21,16],[27,45,33],[24,39,28]]

Example 2:
Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
Output: [[45,45,45],[45,45,45],[45,45,45]]
*/

class Solution {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] ret = new int[m][n];
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                ret[i][j] = matrixSum(mat, K, i, j);
            }
        }
        return ret;
    }
    
    public int matrixSum(int[][] mat, int K, int r, int c) {
        int sum = 0;
        for(int i = r-K ; i <= r+K ; i++) {
            for(int j = c-K ; j <= c+K ; j++) {
                if(i >= 0 && j >= 0 && i < mat.length && j < mat[0].length) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}
