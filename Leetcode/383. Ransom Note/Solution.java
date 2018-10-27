/* https://leetcode.com/problems/ransom-note

Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length())
            return false;
        
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(int i = 0 ; i < ransomNote.length() ; i++) {
            Character c = ransomNote.charAt(i);
            
            map1.put(c, map1.getOrDefault(c, 0) + 1);
            // map1.put(c, (map1.containsKey(c) ? map1.get(c) + 1 : 1));
        }
        
        for(int j = 0 ; j < magazine.length() ; j++) {
            Character c = magazine.charAt(j);

            map2.put(c, map2.getOrDefault(c, 0) + 1);
            // map2.put(c, (map2.containsKey(c) ? map2.get(c) + 1 : 1));
        }
        
        for(int i = 0 ; i < ransomNote.length() ; i++) {
            Character c = ransomNote.charAt(i);
            if(map2.containsKey(c) == false || map1.get(c) > map2.get(c))
                return false;
        }       
        return true;
    }
}

public class Solution {
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
                if(k == 1)
                    map.remove(c);
                else
                    map.put(c, k-1);
            }
            else
                return false;
        }
        return true;
    }
}
