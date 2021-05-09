/* https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

Given a string s formed by digits ('0' - '9') and '#'.

We want to map s to English lowercase characters as follows:
Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.

Return the string formed after mapping.
It's guaranteed that a unique mapping will always exist.

Example 1:
Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".

Example 2:
Input: s = "1326#"
Output: "acz"

Example 3:
Input: s = "25#"
Output: "y"

Example 4:
Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
Output: "abcdefghijklmnopqrstuvwxyz"
*/

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        
        int i = 0;
        while(i < s.length()) {
            if(i+2 < s.length() && chars[i+2] == '#') { //j-z
                int n = (chars[i]-'0')*10 + (chars[i+1]-'0'); //10-26
                n = n-10; //0-16
                n = n +'j'; //j-z
                sb.append((char)(n));
                i += 3;
            }
            else { //a-i
                char c = chars[i];
                c = (char)(c-'1'); //index of 1-9
                c = (char)(c+'a'); //converted to index of a-i
                sb.append(c);
                i += 1;
            }
        }
        return sb.toString();
    }
}

class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb=new StringBuilder();
        char[] str=s.toCharArray();
        for(int i = 0 ; i < str.length ; i++) {
            if(i < str.length - 2 && str[i+2] == '#') {
                int n = (str[i]-'0')*10 + (str[i+1]-'0');
                sb.append((char)('j'+n-10));
                i += 2;
            }
            else sb.append((char)('a'+str[i]-'1'));
        }
        return sb.toString();
    }
}
