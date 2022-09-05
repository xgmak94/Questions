/* https://leetcode.com/problems/generate-parentheses/

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:
Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]

Constraints:
1 <= n <= 8
*/

/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    let list = [];
    var generate = function(curr, open, close) {
        if(curr.length === 2*n) {
            list.push(curr);
            return;
        }
        
        if(open < n) {
            generate(curr.slice() + '(', open+1, close);
        }
        if(close < open) {
            generate(curr.slice() + ')', open, close+1);
        }
    }
    generate("", 0, 0);
    return list;
};
