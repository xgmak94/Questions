/* https://leetcode.com/problems/decode-ways

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

*/

class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if(s == null || n == 0) return 0;
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, 0);
        
        dp[0] = 1; // 1 way to decode empty
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;
        
        for(int i = 2 ; i <= n ; i++) {
            int singleDigit = Integer.valueOf(s.substring(i-1, i)); //prev digit
            int doubleDigit = Integer.valueOf(s.substring(i-2, i)); //prev 2 digits
            if(singleDigit >= 1 && singleDigit <= 9) { //add numways to decode i-1 length if last digit is not 0
                dp[i] += dp[i-1];
            }
            if(doubleDigit >= 10 && doubleDigit <= 26) { //add numways to decode i-2
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
