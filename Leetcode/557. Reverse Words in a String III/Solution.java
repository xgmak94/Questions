/* https://leetcode.com/problems/reverse-words-in-a-string-iii

Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.

*/
class Solution {
    public String reverseWords(String s) {
        StringBuilder reversed = new StringBuilder();        
        StringBuilder word = new StringBuilder();
        
        for(int i = 0 ; i < s.length() ; i++) {
            Character c = s.charAt(i);
            if (c != ' ')
                word.append(c); 
            else {
                reversed.append(word.reverse());
                reversed.append(" ");
                word.setLength(0);
            }
        }
        reversed.append(word.reverse());     
        return reversed.toString();
    }
}

class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        
        StringBuilder newString = new StringBuilder();
        
        for(int i = 0 ; i < words.length ; i++) {
            StringBuilder sb = new StringBuilder(words[i]);
            words[i] = sb.reverse().toString();     
            newString.append(words[i] +" ");
        }
        return newString.substring(0, newString.length() - 1);
    }
}
