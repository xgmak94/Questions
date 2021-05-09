/* https://leetcode.com/problems/first-unique-character-in-a-string

Given a string, find the first non-repeating character in it and return it's index. 
If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
*/

class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            freq[c-'a']++;
        }
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(freq[c-'a'] == 1)
                return i;
        }
        return -1;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, Integer.MAX_VALUE);
            }
            else {
                map.put(c, i);
            }
        }
        
        int firstIndex = Integer.MAX_VALUE;
        for(char c : map.keySet()) {
            firstIndex = Math.min(map.get(c), firstIndex);
        }
        return firstIndex == Integer.MAX_VALUE ? -1 : firstIndex;
    }
}

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(map.get(c) == 1) {
                return i;
            }
        }
        return -1;
    }
}
