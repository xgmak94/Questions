/* https://leetcode.com/problems/palindromic-substrings/description/

Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:
Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:
Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".

*/

class Solution {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0)
            return 0;
        
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++) {
            count += palindrome(s, i, i);
            count += palindrome(s, i, i + 1);
        }
        return count;
    }
    
    public int palindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
