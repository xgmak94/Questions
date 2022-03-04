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

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int pair = 0;

        for(char c : s.toCharArray()) {
            if(set.contains(c)) { //any paired up chars can be a palindrome
                set.remove(c);
                pair++;
            }
            else {
                set.add(c);
            }
        }
        // if(set.isEmpty()) return 2*pair;
        // else return 2*pair+1;
        return set.isEmpty() ? 2*pair : 2*pair + 1; //can add an extra character if available
    }
}
