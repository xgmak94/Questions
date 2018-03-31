/* https://leetcode.com/problems/longest-substring-without-repeating-characters

Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/

class Solution {
    public static int lengthOfLongestSubstring(String input) {
        if (input.length() == 0)
            return 0;

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
}
