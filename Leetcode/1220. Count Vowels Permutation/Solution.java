/* https://leetcode.com/problems/count-vowels-permutation/

Given an integer n, your task is to count how many strings of length n can be formed under the following rules:

Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u')
Each vowel 'a' may only be followed by an 'e'.
Each vowel 'e' may only be followed by an 'a' or an 'i'.
Each vowel 'i' may not be followed by another 'i'.
Each vowel 'o' may only be followed by an 'i' or a 'u'.
Each vowel 'u' may only be followed by an 'a'.
Since the answer may be too large, return it modulo 10^9 + 7.

Example 1:
Input: n = 1
Output: 5
Explanation: All possible strings are: "a", "e", "i" , "o" and "u".

Example 2:
Input: n = 2
Output: 10
Explanation: All possible strings are: "ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua".

Example 3: 
Input: n = 5
Output: 68

Constraints:
1 <= n <= 2 * 10^4
*/

class Solution {
    public int countVowelPermutation(int n) {
        double[][] dp = new double[n+1][5];
        double mod = 1000000007;
        //[i][0] = a
        //[i][1] = e
        //[i][2] = i
        //[i][3] = o
        //[i][4] = u
        dp[1] = new double[]{1, 1, 1, 1, 1};
        for(int i = 2 ; i <= n ; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4]) % mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % mod;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % mod;
            dp[i][3] = (dp[i-1][2]) % mod;
            dp[i][4] = (dp[i-1][2] + dp[i-1][3]) % mod;
        }
        double sum = 0;
        for(double val : dp[n]) {
            sum = (sum + val) % mod;
        }
        return (int)sum;
    }
}
