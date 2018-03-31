/* https://leetcode.com/problems/valid-palindrome/description/

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

*/

class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                sb.append(Character.toLowerCase(c));
            }
        }
        String modified = sb.toString();
        
        for(int i = 0 ; i < modified.length() / 2 ; i++) {
            if(modified.charAt(i) != modified.charAt(modified.length() - 1 - i))
                return false;
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