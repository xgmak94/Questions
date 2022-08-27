/* https://leetcode.com/problems/longest-palindromic-substring/

Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters.
*/

/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    function isPalindrome(l, r) {
        while(l >= 0 && r < s.length && s.charAt(l) === s.charAt(r)) {
            if(r-l+1 > maxLength) {
                maxLength = r-l+1;
                maxLeft = l;
            }
            l--;
            r++;
        }
    }
    let maxLeft = 0;
    let maxLength = 0;
    
    for(let i = 0 ; i < s.length ; i++) {
        isPalindrome(i, i);
        isPalindrome(i, i+1);
    }
    return s.substring(maxLeft, maxLeft + maxLength);
};
