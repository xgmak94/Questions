/* https://leetcode.com/problems/longest-substring-without-repeating-characters

Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Example 4:

Input: s = ""
Output: 0
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/
import java.util.*;

class Solution {
    public static int lengthOfLongestSubstring(String input) {
        if (input.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        
        for(int start = 0, end = 0 ; end < input.length() ; ++end) {
            char c = input.charAt(end);
            if(map.containsKey(c)) {
                start = Math.max(start, map.get(input.charAt(end)) + 1);
            }
            map.put(c, end);

            int currLength = end - start + 1;
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        int ex1 = lengthOfLongestSubstring("abcabcbb");
        int ex2 = lengthOfLongestSubstring("bbbbb");
        int ex3 = lengthOfLongestSubstring("pwwkew");
        int ex4 = lengthOfLongestSubstring("");

        System.out.println(ex1);
        System.out.println(ex2);
        System.out.println(ex3);
        System.out.println(ex4);
    }
}
