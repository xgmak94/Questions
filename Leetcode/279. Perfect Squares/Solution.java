/* https://leetcode.com/problems/perfect-squares/description/

Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

Credits:
Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.

*/

class Solution {
    public int numSquares(int n) {
        if(n == 0)
            return 0;
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        for(int i = 1 ; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            int j = 1;
            
            while(i - j*j >= 0) {
                min = Math.min(dp[i -j*j] + 1, min);
                j++;
            }
            dp[i] = min;
        }
        return dp[n];
    }
}
