/* https://leetcode.com/problems/uncommon-words-from-two-sentences/description/

We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Return a list of all uncommon words. 

You may return the list in any order.

Example 1:
Input: A = "this apple is sweet", B = "this apple is sour"
Output: ["sweet","sour"]

Example 2:
Input: A = "apple apple", B = "banana"
Output: ["banana"]
*/

class Solution {
    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> count = new HashMap();
        A = String.join(" ", A, B);
        for (String word: A.split(" +")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        List<String> list = new ArrayList<>();
        for(String word : count.keySet()) {
            if(count.get(word) == 1)
                list.add(word);
        }

        String[] ret = new String[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
