/* https://leetcode.com/problems/flipping-an-image/

Given a binary matrix A, we want to flip the image horizontally, then invert it, and return the resulting image.

To flip an image horizontally means that each row of the image is reversed.  For example, flipping [1, 1, 0] horizontally results in [0, 1, 1].

To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].

Example 1:
Input: [[1,1,0],[1,0,1],[0,0,0]]
Output: [[1,0,0],[0,1,0],[1,1,1]]
Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]

Example 2:
Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
Explanation: First reverse each row: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]

*/

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        A = flip(A);
        A = invert(A);
        return A; //return invert(flip(A))
    }
    public int[][] flip(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n/2 ; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n-j-1];
                A[i][n-j-1] = temp;
            }
        }
        return A;
    }
    public int[][] invert(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(A[i][j] == 0) {
                    A[i][j] = 1;
                }
                else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
}
