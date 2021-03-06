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
        if(s == null || s.length() == 0)
            return 0;
        
        int len = s.length();
        
        int[] dp = new int[len+1];
        Arrays.fill(dp, 0);
        
        dp[0] = 1; // 1 way to decode empty
        dp[1] = s.charAt(0) == '0' ? 0 : 1; // 0 or 1 way to decode 1 char
        
        for(int i = 2 ; i <= len ; i++) {
            int first = Integer.valueOf(s.substring(i-1, i)); //last digit
            int second = Integer.valueOf(s.substring(i-2, i)); // last two digits
            if(first > 0 && first < 10) {
                dp[i] = dp[i-1] + 1;
            }
            if(second >= 10 && second <= 26) {
                dp[i] = dp[i-2] + 2;
            }
        }
        return dp[len];
    }
}
