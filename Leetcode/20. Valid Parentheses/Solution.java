/* https://leetcode.com/problems/valid-parentheses/description/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        
        for(int i = 0 ; i < length ; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if(!stack.empty() && c == ')' && stack.peek() == '(') {
                    stack.pop();
                }
                else if(!stack.empty() && c == '}' && stack.peek() == '{') {
                    stack.pop();
                }
                else if(!stack.empty() && c == ']' && stack.peek() == '[') {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
