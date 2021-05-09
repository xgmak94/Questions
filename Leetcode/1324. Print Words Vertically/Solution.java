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
        List<String> ret = new ArrayList<>();
        String[] words = s.split(" ");
        if(words.length == 0) 
            return ret;

        int maxLength = 0;
        
        for(int i = 0 ; i < words.length ; i++)
            maxLength = Math.max(maxLength, words[i].length());
        
        for(int i = 0 ; i < maxLength ; i++) {
            StringBuilder curr = new StringBuilder();
            for(int j = 0 ; j < words.length ; j++) {
                if(i >= words[j].length()) { //if word is not long enough use empty space
                    curr.append(" ");
                }
                else {
                    curr.append(words[j].charAt(i));
                }
            }
            curr = removeTrailWhitespace(curr);
            ret.add(curr.toString());
        }
        return ret;
    }
    
    public StringBuilder removeTrailWhitespace(StringBuilder str) {
        for(int i = str.length() - 1 ; i >= 0 ; i--) {
            if (!Character.isWhitespace(str.charAt(i))) {
                break;
            }
            else {
                str.deleteCharAt(i);
            }
        }
        return str;
    }
}
