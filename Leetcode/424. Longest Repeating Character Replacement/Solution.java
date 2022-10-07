/* https://leetcode.com/problems/longest-repeating-character-replacement/

You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

 

Example 1:

Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.
Example 2:

Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
 

Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*/

class Solution {
    public int characterReplacement(String s, int k) {
        int[] freqs = new int[26];
        int longest = 0;
        int maxFreq = 0;
        int l = 0;
        int r = 0;
        
        while(r < s.length()) {
            char c = s.charAt(r);
            freqs[c - 'A']++;
            maxFreq = Math.max(maxFreq, freqs[c - 'A']);
            
            while((r-l+1) - maxFreq > k) {
                freqs[s.charAt(l) - 'A']--;
                l++;
            }
            longest = Math.max(longest, r-l+1);
            r++;
        }
        return longest;
    }
    public int maxCharacter(int[] freqs) {
        int max = 0;
        for(int freq : freqs) {
            max = Math.max(max, freq);
        }
        return max;
    }
}
