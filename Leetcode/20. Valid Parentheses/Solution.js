/* 20. Valid Parentheses

Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false

Constraints:
1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function (s) {
  let stack = [];

  for (let i = 0; i < s.length; i++) {
    let c = s.charAt(i);
    if (c === '(' || c === '{' || c === '[') {
      stack.push(c);
    } else if (c === ')' || c === '}' || c === ']') {
      let top = stack.pop();
      if (c === ')') {
        if (top !== '(') return false;
      } else if (c === '}') {
        if (top !== '{') return false;
      } else if (c === ']') {
        if (top !== '[') return false;
      }
    }
  }
  return stack.length === 0;
};
