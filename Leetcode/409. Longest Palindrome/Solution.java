/* https://leetcode.com/problems/longest-palindrome

Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

public class Solution {
    public int longestPalindrome(String s) {
        int length = s.length();
        int count = 0;
        
        HashSet<Character> set = new HashSet<>();
        for(int i = 0 ; i < length ; i++) {
            Character c = s.charAt(i);
            if(set.contains(c)) {
                set.remove(c);
                count++;
            }
            else {
                set.add(c);
            }
        }
        return (set.isEmpty()) ? 2*count : 2*count + 1;
    }
}
