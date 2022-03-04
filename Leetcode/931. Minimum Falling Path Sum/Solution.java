/* https://leetcode.com/problems/minimum-falling-path-sum/

Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

Example 1:
Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.

Example 2:
Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.

Constraints:
n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100
*/

//can also just modify original array
class Solution {
    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        int[][] dp = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            dp[0][i] = A[0][i];
        }
        
        for(int i = 1 ; i < n ; i++) { //skip first row that was initialized
            for(int j = 0 ; j < n ; j++) {
                int minPrevRow = dp[i-1][j];
                if(j-1 >= 0) minPrevRow = Math.min(dp[i-1][j-1], minPrevRow);
                if(j+1 < n) minPrevRow = Math.min(dp[i-1][j+1], minPrevRow);
                
                dp[i][j] = A[i][j] + minPrevRow;
            }
        }

        //get minimum in last row
        int minSum = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++) {
            minSum = Math.min(dp[n-1][i], minSum);
        }
        return minSum;
    }
}
