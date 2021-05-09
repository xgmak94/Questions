/* https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.

We repeatedly make duplicate removals on S until we no longer can.

Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.

Example 1:
Input: "abbaca"
Output: "ca"
Explanation: 
For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal, and this is the only possible move.  The result of this move is that the string is "aaca", of which only "aa" is possible, so the final string is "ca". 
*/

class Solution {
     public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (char c : S.toCharArray()) {
            int size = sb.length();
            if (size > 0 && sb.charAt(size - 1) == c) { //remove dups
                sb.deleteCharAt(size - 1); 
            }
            else {
                sb.append(c); 
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : S.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.add(c);
            }
        }
        
        StringBuilder ret = new StringBuilder();
        while(!stack.isEmpty()) {
            ret.insert(0, stack.pop());
        }
        return ret.toString();
    }
}
