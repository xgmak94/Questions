/* https://leetcode.com/problems/most-common-word/description/

Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

Example:
Input: 
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]
Output: "ball"
Explanation: 
"hit" occurs 3 times, but it is a banned word.
"ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
Note that words in the paragraph are not case sensitive,
that punctuation is ignored (even if adjacent to words, such as "ball,"), 
and that "hit" isn't the answer even though it occurs more because it is banned.
 

Note:

1 <= paragraph.length <= 1000.
1 <= banned.length <= 100.
1 <= banned[i].length <= 10.
The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
Different words in paragraph are always separated by a space.
There are no hyphens or hyphenated words.
Words only consist of letters, never apostrophes or other punctuation symbols.

*/

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        if (paragraph == null)
            return null;
        
        int len = paragraph.length();
        Set<String> bannedSet = new HashSet<>();
        Map<String, Integer> freq = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for (String str : banned)
            if (str != null)
                bannedSet.add(str);
        
        for (int i = 0; i <= len; i++) {
            if (i < len && Character.isLetter(paragraph.charAt(i))) {
                sb.append(Character.toLowerCase(paragraph.charAt(i)));
            } else {
                if (sb.length() > 0) {
                    String str = sb.toString();
                    if (!bannedSet.contains(str)) {
                        freq.put(str, freq.getOrDefault(str, 0) + 1);
                    }
                    sb.setLength(0);
                }
            }
        }
        String res = null;
        int max = 0;
        for (String str : freq.keySet()) {
            if (freq.get(str) > max) {
                max = freq.get(str);
                res = str;
            }
        }

        return res;
    }
}