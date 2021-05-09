/* https://leetcode.com/problems/maximum-length-of-repeated-subarray/description/

Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Example 1:
Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
*/

class Solution {
    public int findLength(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int max = 0;    
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 0 ; i <= m ; i++) {
            for(int j = 0 ; j <= n ; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                else if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
}
