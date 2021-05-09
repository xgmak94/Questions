/* https://leetcode.com/problems/longest-palindromic-substring/description/

Given a string s, find the longest palindromic substring in s. Y
ou may assume that the maximum length of s is 1000.

Example:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example:
Input: "cbbd"
Output: "bb"
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <= 1) return s; //length 0, 1 always palindrome
        int[] max = new int[2]; // left index, length
      
        for(int i = 0 ; i < s.length() - 1 ; i++) {
            palindrome(s, i, i, max);
            palindrome(s, i, i+1, max);
        }
        return s.substring(max[0], max[0] + max[1]);
    }

    public void palindrome(String s, int left, int right, int[] max) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int start = left+1;
        int length = right-left-1;
        if(length > max[1]) {
            max[0] = start;
            max[1] = length;
        }
    }
}


class Solution {
    int maxLeft = 0;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) { // length 0 or length 1
            return s;
        }
        
        for(int i = 0 ; i < len - 1 ; i++) {
            palindrome(s, i, i);
            palindrome(s, i, i + 1);
        }
        return s.substring(maxLeft, maxLeft + maxLength);
    }
    
    public void palindrome(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        if(maxLength < right - left - 1) {
            maxLeft = left + 1;
            maxLength = right - left - 1;
        }
    }
}