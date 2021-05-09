/* https://leetcode.com/problems/reformat-the-string/

Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. 
That is, no two adjacent characters have the same type.

Return the reformatted string or return an empty string if it is impossible to reformat the string.

Example 1:
Input: s = "a0b1c2"
Output: "0a1b2c"
Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.

Example 2:
Input: s = "leetcode"
Output: ""
Explanation: "leetcode" has only characters so we cannot separate them by digits.

Example 3:
Input: s = "1229857369"
Output: ""
Explanation: "1229857369" has only digits so we cannot separate them by characters.

Example 4:
Input: s = "covid2019"
Output: "c2o0v1i9d"

Example 5:
Input: s = "ab123"
Output: "1a2b3"
*/

class Solution {
    public String reformat(String s) {
        char[] arr = s.toCharArray();        
        List<Character> digits = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        
        for(char c : arr) {
            if(Character.isDigit(c)) {
                digits.add(c);
            }
            else {
                chars.add(c);
            }
        }
        if(Math.abs(digits.size() - chars.size()) > 1) return "";
        
        StringBuilder sb = new StringBuilder();
        int digitsIndex = 0, charsIndex = 0;
        boolean digitNext = (digits.size() > chars.size() ? true : false); //start with the larger list

        for(int i = 0 ; i < s.length() ; i++) {
            if(digit == true) sb.append(digits.get(digitsIndex++));
            else sb.append(chars.get(charsIndex++));
            digitNext = !digitNext;
        }
        return sb.toString();
    }
}

class Solution {
    public String reformat(String s) {
        char[] arr = s.toCharArray();        
        List<Character> digits = new ArrayList<>();
        List<Character> chars = new ArrayList<>();
        
        for(char c : arr) {
            if(Character.isDigit(c)) digits.add(c);
            else chars.add(c);
        }
        if(Math.abs(digits.size() - chars.size()) > 1) return "";
        
        StringBuilder sb = new StringBuilder();
        int digitsIndex = 0;
        int charsIndex = 0;
        
        if(digits.size() > chars.size()) {            
            for(int i = 0 ; i < s.length() ; i++) {
                if(i % 2 == 0) {
                    sb.append(digits.get(digitsIndex++));
                }
                else {
                    sb.append(chars.get(charsIndex++));
                }
            }
        }
        else {
            for(int i = 0 ; i < s.length() ; i++) {
                if(i % 2 == 0) {
                    sb.append(chars.get(charsIndex++));
                }
                else {
                    sb.append(digits.get(digitsIndex++));
                }
            }
        }
        return sb.toString();
    }
}
