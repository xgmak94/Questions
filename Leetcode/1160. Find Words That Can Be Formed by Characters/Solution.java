/* https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.

*/

class Solution {
     public static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
		//Count char of Chars String
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
		// Comparing each word in words
        for (String word : words) {
			// simple making copy of seen arr
            int[] tSeen = Arrays.copyOf(seen, seen.length); 
            int Tcount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if (Tcount == word.length())
                count += Tcount;
        }
        return count;
    }
}

class Solution {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < chars.length() ; i++) {
            char c = chars.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int length = 0;
        
        for(int i = 0 ; i < words.length ; i++) {
            Map<Character, Integer> clone = new HashMap<>(map);
            if(check(words[i], clone)) {
                length += words[i].length();
            }
        }
        return length;
    }
    
    public boolean check(String word, Map<Character, Integer> map) {
        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            if(map.get(c) == null || map.get(c) < 1) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
