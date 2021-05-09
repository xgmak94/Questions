/* https://leetcode.com/problems/backspace-string-compare/description/

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        
        for(int i = 0 ; i < S.length() ; i++) {
            char c = S.charAt(i);
            if(c != '#') {
                first.append(c);
            }
            else if(first.length() > 0) { //make sure theres a char to delete if #
                first.deleteCharAt(first.length() - 1);
            }
        }
        
        for(int j = 0 ; j < T.length() ; j++) {
            char d = T.charAt(j);
            if(d != '#') {
                second.append(d);
            }
            else if(second.length() > 0) { //make sure theres a char to delete if #
                second.deleteCharAt(second.length() - 1);
            }
        }
        return first.toString().equals(second.toString());
    }
}
