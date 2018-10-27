/* https://leetcode.com/problems/reverse-vowels-of-a-string

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/
public class Solution {
    public String reverseVowels(String word) {
        String vowels = "aeiouAEIOU"; // vowels we are looking for

        char[] chars = word.toCharArray();
        int start = 0;
        int end = word.length() - 1;

        while(start < end) {
            while(start < end && !vowels.contains(chars[start]+"")) { //find first vowel
                start++;
            }

            while(start < end && !vowels.contains(chars[end]+"")) { //find last vowel
                end--;
            }

            swap(chars, start, end); //swap outside vowels
            start++; end--;
        }
        return new String(chars);
    }
    public void swap(char[] chars, int start, int end) {
        char temp = chars[start];
        chars[start] = chars[end];
        chars[end] = temp;
    }
}

public class Solution {
    public String reverseVowels(String word) {
        String vowels = "aeiouAEIOU";
        int length = word.length();

        Stack<Character> s = new Stack<>();
        StringBuilder ret = new StringBuilder();

        for(int i = 0 ; i < length ; i++) {
            char c = word.charAt(i);
            if(vowels.contains(c + ""))
                s.push(c);
        }
        
        for(int i = 0 ; i < length ; i++) {
            char c = word.charAt(i);
            if(vowels.contains(c + ""))
                ret.append(s.pop());
            else
                ret.append(c);
        }      
        return ret.toString();
    }
}
