/* https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, find the longest palindromic substring in s. Y
ou may assume that the maximum length of s is 1000.

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
*/

import java.util.*;
class Solution {
    public static String longestPalindrome(String s) {
        if(s.length() <= 1) return s; //length 0, 1 always palindrome
        int[] max = new int[2]; // left index, length
      
        for(int i = 0 ; i < s.length() ; i++) { //palindrome centered around i
            palindrome(s, i, i, max);
            palindrome(s, i, i+1, max);
        }
        return s.substring(max[0], max[0] + max[1]);
    }

    public static void palindrome(String s, int left, int right, int[] max) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int currLength = right-left-1; //normally right-left+1, but left and right are both off by 1
        if(max[1] < currLength) {
            max[0] = left+1;
            max[1] = currLength;
        }
    }
    
    public static void main(String[] args) {
        String ex1 = longestPalindrome("babad");
        String ex2 = longestPalindrome("cbbd");
        String ex3 = longestPalindrome("a");
        String ex4 = longestPalindrome("ac");

        System.out.println(ex1);
        System.out.println(ex2);
        System.out.println(ex3);
        System.out.println(ex4);
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