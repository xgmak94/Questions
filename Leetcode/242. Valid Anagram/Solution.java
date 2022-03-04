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

        int[] freq = new int[26];
        for(char c : s.toCharArray()) freq[c-'a']++;
        for(char d : t.toCharArray()) {
            if(freq[d-'a'] == 0) return false;
            freq[d-'a']--;
        }
        
        for(int i = 0 ; i < 26 ; i++) {
            if(freq[i] != 0) return false;
        }
        return true;
    }
}

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) { //insert all characters from first string into map
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(char c : t.toCharArray()) {
            if(map.get(c) == null) { //not in first string, not an anagram
                return false;
            }
            else {
                map.put(c, map.get(c)-1);
                if(map.get(c) == 0) { //if it is now 0 just remove it
                    map.remove(c);
                }
            }
        }
        return map.size() == 0;
    }
}
