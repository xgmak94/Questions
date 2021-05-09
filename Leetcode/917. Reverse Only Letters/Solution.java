/* https://leetcode.com/problems/reverse-only-letters/description/

Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, 
and all letters reverse their positions.

Example 1:
Input: "ab-cd"
Output: "dc-ba"

Example 2:
Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"

Example 3:
Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"

*/

class Solution {
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        for(char c : S.toCharArray()) { //push all characters into a stack, reversed when we pop
            if(Character.isLetter(c))
                stack.push(c);
        }
        
        for(char c : S.toCharArray()) {
            if(Character.isLetter(c)) //if its a letter take from the stack thats reversed
                sb.append(stack.pop());
            else
                sb.append(c);
        }
        return sb.toString();
    }
}
