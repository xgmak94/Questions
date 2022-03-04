/* https://leetcode.com/problems/ransom-note

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()) return false;

        HashMap<Character, Integer> mag = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            mag.put(c, mag.getOrDefault(c, 0) + 1);
        }
        
        for(char c : ransomNote.toCharArray()) {
            if(mag.get(c) == null || mag.get(c) <= 0) {
                return false;
            }
            else {
                mag.put(c, mag.get(c) - 1);
            }
        }
        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        
        HashMap<Character, Integer> ransom = new HashMap<>();
        HashMap<Character, Integer> mag = new HashMap<>();
        
        for(char c : ransomNote.toCharArray()) {
            ransom.put(c, ransom.getOrDefault(c, 0) + 1);
        }

        for(char c : magazine.toCharArray()) {
            mag.put(c, mag.getOrDefault(c, 0) + 1);
        }
        
        for(char c : ransomNote.toCharArray()) {
            if(mag.containsKey(c) == false || ransom.get(c) > mag.get(c)) {
                return false;
            }
        } 
        return true;
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0 ; i < magazine.length() ; i++) {
            Character c = magazine.charAt(i);
            map.put(c, (map.containsKey(c) ? map.get(c) + 1 : 1));
        }
        
        for(int i = 0 ; i < ransomNote.length() ; i++) {
            Character c = ransomNote.charAt(i);
            Integer k = map.get(c);
            if(k != null) {
                if(k == 1) map.remove(c);
                else map.put(c, k-1);
            }
            else {
                return false;
            }
        }
        return true;
    }
}
