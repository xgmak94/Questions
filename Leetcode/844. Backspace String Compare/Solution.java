/* https://leetcode.com/problems/backspace-string-compare/

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
    public boolean backspaceCompare(String s, String t) {
        String first = make(s);
        String second = make(t);
        
        return first.equals(second);
    }
    public String make(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == '#' && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            else if(c != '#'){
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
