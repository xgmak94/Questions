/* https://leetcode.com/problems/valid-anagram

Given two strings s and t, write a function to determine if t is an anagram of s.

For example,
s = "anagram", t = "nagaram", return true.
s = "rat", t = "car", return false.

Note:
You may assume the string contains only lowercase alphabets.
*/

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char c : t.toCharArray()) {
            Integer count = map.get(c);
            if(count == null) { //not in first string, not an anagram
                return false;
            }
            else {
                map.put(c, count-1);
                if(map.get(c) == 0) { //if it is now 0 just remove it
                    map.remove(c);
                }
            }
        }
        return map.size() == 0;
    }
}
