/* https://leetcode.com/problems/minimum-falling-path-sum/

Given a square array of integers A, we want the minimum sum of a falling path through A.

A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.

Example 1:
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: 12
Explanation: 
The possible falling paths are:
[1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
[2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
[3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
The falling path with the smallest sum is [1,4,7], so the answer is 12.
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
