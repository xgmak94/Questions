/* https://leetcode.com/problems/maximum-number-of-balloons/

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

Example 1:
Input: text = "nlaebolko"
Output: 1

Example 2:
Input: text = "loonbalxballpoon"
Output: 2

Example 3:
Input: text = "leetcode"
Output: 0

Constraints:
1 <= text.length <= 104
text consists of lower case English letters only.
*/

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] chars = new int[26];
        
        for(char c : text.toCharArray()) chars[c-'a']++;

        int min = chars['b'-'a']; //1 b
        min = Math.min(min, chars['a'-'a']); //1 a
        min = Math.min(min, chars['l'-'a'] / 2); //2 l
        min = Math.min(min, chars['o'-'a'] / 2); //2 o
        min = Math.min(min, chars['n'-'a']); //1 n
        
        return min;
    }
}
