/* https://leetcode.com/problems/valid-parentheses/description/

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            }
            else if(c == '{') {
                stack.push('}');
            }
            else if(c == '[') {
                stack.push(']');
            }
            else if(stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        int length = s.length();
        
        for(char c : s.toCharArray()) {
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(c == ')' && top != '(')
                    return false;
                else if(c == '}' && top != '{')
                    return false;
                else if(c == ']' && top != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
