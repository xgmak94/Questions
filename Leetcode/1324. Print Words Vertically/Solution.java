/* https://leetcode.com/problems/print-words-vertically/

Given a string s. 
Return all the words vertically in the same order in which they appear in s.
Words are returned as a list of strings, complete with spaces when is necessary. (Trailing spaces are not allowed).
Each word would be put on only one column and that in one column there will be only one word.

Example 1:
Input: s = "HOW ARE YOU"
Output: ["HAY","ORO","WEU"]
Explanation: Each word is printed vertically. 
 "HAY"
 "ORO"
 "WEU"

Example 2:
Input: s = "TO BE OR NOT TO BE"
Output: ["TBONTB","OEROOE","   T"]
Explanation: Trailing spaces is not allowed. 
"TBONTB"
"OEROOE"
"   T"

Example 3:
Input: s = "CONTEST IS COMING"
Output: ["CIC","OSO","N M","T I","E N","S G","T"]
*/

class Solution {
    public List<String> printVertically(String s) {
        List<String> list = new ArrayList<>();
        String[] words = s.split(" ");
        if(words.length == 0) return list;

        int maxLength = 0;
        for(String word : words) {
            maxLength = Math.max(maxLength, word.length())
        }
        
        for(int i = 0 ; i < maxLength ; i++) { //i is current character index
            StringBuilder curr = new StringBuilder();
            for(String word : words) {
                if(i >= word.length()) {
                    curr.append(" ");
                }
                else {
                    curr.append(word.charAt(i));
                }
            }
            removeTrailWhitespace(curr);
            list.add(curr.toString());
        }
        return list;
    }
    
    public StringBuilder removeTrailWhitespace(StringBuilder str) {
        while(str.charAt(str.length() - 1) == ' ') {
            str.deleteCharAt(str.length() - 1);
        }
        return str;
    }
}
