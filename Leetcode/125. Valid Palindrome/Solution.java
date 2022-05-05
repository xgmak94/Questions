/* https://leetcode.com/problems/valid-palindrome/

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder(); //create a string with only alphanumeric characters
        for(char c : s.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        
        for(int i = 0 ; i < sb.length() / 2 ; i++) {
            if(sb.charAt(i) != sb.charAt(sb.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        if(s.length() < 2)
            return true;
        
        Stack<Character> stack = new Stack<>();
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int len = s.length();

        int idx = 0;
        while(idx < len / 2) {
            stack.push(s.charAt(idx));
            idx++;
        }
        if(len % 2 == 1)
            idx++;
        
        while(idx != len) {
            if(s.charAt(idx) == stack.pop()) {
                idx++;
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
}