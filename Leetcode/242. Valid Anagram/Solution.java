/* https://leetcode.com/problems/valid-anagram/description/

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:

*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0 ; i < t.length() ; i++) {
            char c = t.charAt(i);
            Integer count = map.get(c);
            if(count == null) {
                return false;
            }
            else if(count == 1) {
                map.remove(c);
            }
            else {
                map.put(c, count-1);
            }
        }
        
        return map.size() == 0;
    }
}
