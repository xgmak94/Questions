/* https://leetcode.com/problems/find-and-replace-pattern/

Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

Example 1:
Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.

Example 2:
Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]

Constraints:
1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.
*/

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(String word : words) {
            if(match(word, pattern)) list.add(word);
        }
        return list;
    }
    
    public boolean match(String word, String pattern) {
        if(word.length() != pattern.length()) return false;
        
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            char d = pattern.charAt(i);
            
            if(!map.containsKey(c) && !map.containsValue(d)) { //if the char in word and the pattern char have not been used yet
                map.put(c, d);
            }
            else {
                if(map.get(c) == null || map.get(c) != d) return false;
            }
        }
        return true;
    }
}
