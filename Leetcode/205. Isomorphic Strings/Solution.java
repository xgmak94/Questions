/* https://leetcode.com/problems/isomorphic-strings/description/

Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.

*/

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        
        if(s.length() != t.length()) {
            return false;
        }
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            char d = t.charAt(i);
            
            if(!map.containsKey(c) && !map.containsValue(d)) {
                map.put(c, d);
            }
            else {
                if(map.get(c) == null || !map.get(c).equals(d)) {
                    return false;
                }
            }
        }
        return true;
    }
}
