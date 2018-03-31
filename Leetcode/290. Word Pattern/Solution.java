/* https://leetcode.com/problems/word-pattern/description/

Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:
pattern = "abba", str = "dog cat cat dog" should return true.
pattern = "abba", str = "dog cat cat fish" should return false.
pattern = "aaaa", str = "dog cat cat dog" should return false.
pattern = "abba", str = "dog dog dog dog" should return false.
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

*/

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()) { // as many words as there are chars in pattern
            return false;
        }
        
        Map<Character, String> map = new HashMap<>();
        
        for(int i = 0 ; i < pattern.length() ; i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            if(map.containsKey(c)) {
                if(!map.get(c).equals(word)) { //if the key is not right, false
                    return false;
                }
            }
            else {
                if(map.containsValue(word)) { //if the key does not exist but the value does, false
                    return false;
                }
                map.put(c, word);
            }
        }
        return true;
    }
}
