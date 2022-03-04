/* https://leetcode.com/problems/reverse-vowels-of-a-string

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
*/

class Solution {
    public String reverseVowels(String word) {
        List<Character> vowels = Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'});
        Set<Character> set = new HashSet<>(vowels);

        char[] chars = word.toCharArray();
        int l = 0;
        int r = word.length() - 1;

        while(l < r) {
            while(l < r && !set.contains(chars[l])) { //find first vowel
                l++;
            }

            while(l < r && !set.contains(chars[r])) { //find last vowel
                r--;
            }
            swap(chars, l, r); //swap outside vowels
            l++;
            r--;
        }
        return new String(chars);
    }
    public void swap(char[] chars, int l, int r) {
        char temp = chars[l];
        chars[l] = chars[r];
        chars[r] = temp;
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
