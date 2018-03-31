/* https://leetcode.com/problems/longest-common-prefix/description/

Write a function to find the longest common prefix string amongst an array of strings.

*/


// vertical scanning
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0 || strs[0].length() == 0)
            return "";
        
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i); // character from first string
            for(int j = 1 ; j < strs.length ; j++) {
                if(i == strs[j].length() || strs[j].charAt(i) != c) { //if we are at the max length of any character or the character doesn't match
                	return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
