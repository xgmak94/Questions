/* https://leetcode.com/problems/repeated-substring-pattern/

Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"
Output: True
Explanation: It's the substring "ab" twice.

Example 2:
Input: "aba"
Output: False

Example 3:
Input: "abcabcabcabc"
Output: True
Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/

class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for(int currLength = s.length() / 2 ; currLength >= 1 ; currLength--) {          
            if(s.length() % currLength != 0) //skips impossible lengths
                continue;

            StringBuilder sb = new StringBuilder();
            
            while(sb.length() < s.length()) {
                sb.append(s.substring(0, currLength));
            }
                
            if(sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
