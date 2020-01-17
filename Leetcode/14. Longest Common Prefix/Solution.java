/* https://leetcode.com/problems/longest-common-prefix/description/

Write a function to find the longest common prefix string amongst an array of strings.

*/

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

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        
        int length = 0;
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
        
        for(int i = 0 ; i < strs[0].length() ; i++) {
            boolean currChar = true;
            for(int j = 1 ; j < strs.length ; j++) {
                if(strs[j].charAt(i) != strs[0].charAt(i)) {
                    currChar = false;
                }
            }
            if(currChar == true)
                length++;
            else
                return strs[0].substring(0, i);
        }
        if(length == 0)
            return "";
        else
            return strs[0].substring(0, length);
    }
}
