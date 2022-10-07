/* https://leetcode.com/problems/length-of-the-longest-alphabetical-continuous-substring/

An alphabetical continuous string is a string consisting of consecutive letters in the alphabet. In other words, it is any substring of the string "abcdefghijklmnopqrstuvwxyz".

For example, "abc" is an alphabetical continuous string, while "acb" and "za" are not.
Given a string s consisting of lowercase letters only, return the length of the longest alphabetical continuous substring.

 

Example 1:

Input: s = "abacaba"
Output: 2
Explanation: There are 4 distinct continuous substrings: "a", "b", "c" and "ab".
"ab" is the longest continuous substring.
Example 2:

Input: s = "abcde"
Output: 5
Explanation: "abcde" is the longest continuous substring.
 

Constraints:

1 <= s.length <= 105
s consists of only English lowercase letters.
*/

class Solution {
    public int longestContinuousSubstring(String s) {
        int longest = 1;
        int[] dp = new int[s.length()];
        Arrays.fill(dp, 1);
        
        for(int i = 1 ; i < s.length() ; i++) {
            if((char)(s.charAt(i) - 1) == s.charAt(i-1)) {
                dp[i] = dp[i-1] + 1;
                longest = Math.max(dp[i], longest);
            }
        }
        return longest;
    }
}
