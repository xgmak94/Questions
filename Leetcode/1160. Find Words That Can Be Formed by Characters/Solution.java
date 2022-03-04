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
    public int countCharacters(String[] words, String chars) {
       int[] seen = new int[26];
       int count = 0;

       for(char c : chars.toCharArray()) seen[c - 'a']++;

       for(String word : words) {
           int[] tSeen = seen.clone();
           if(check(word, tSeen)) {
               count += word.length();
           }
       }
       return count;
   }
   public boolean check(String word, int[] seen) {
       for(char c : word.toCharArray()) {
           if(seen[c-'a'] > 0) {
               seen[c-'a']--;
           }
           else {
               return false;
           }
       }
       return true;
   }
}

class Solution {
     public int countCharacters(String[] words, String chars) {
        int[] seen = new int[26];
        int count = 0;

        for(char c : chars.toCharArray()) {
            seen[c - 'a']++;
        }

        for(String word : words) {
            int[] tSeen = seen.clone();
            int letterCount = 0;
            for(char c : word.toCharArray()) {
                if(tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    letterCount++;
                }
                else break;
            }
            if (letterCount == word.length()) { //if word can be completed
                count += word.length();
            }
        }
        return count;
    }
}
