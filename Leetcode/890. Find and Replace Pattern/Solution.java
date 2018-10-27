/* https://leetcode.com/problems/find-and-replace-pattern/description/

You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 
*/

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        for(String word : words) {
            if(match(word, pattern))
                list.add(word);
        }
        return list;
    }
    
    public boolean match(String word, String pattern) {
        if(word.length() != pattern.length())
            return false;
        
        Map<Character, Character> map = new HashMap<>();
        
        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            char d = pattern.charAt(i);
            
            if(!map.containsKey(c) && !map.containsValue(d)) { //if does
                map.put(c, d);
            }
            else {
                if(map.get(c) == null || map.get(c) != d) {
                    return false;
                }
            }
        }
        return true;
    }
}