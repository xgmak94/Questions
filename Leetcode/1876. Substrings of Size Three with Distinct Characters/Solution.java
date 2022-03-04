/* https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/

A string is good if there are no repeated characters.

Given a string s​​​​​, return the number of good substrings of length three in s​​​​​​.

Note that if there are multiple occurrences of the same substring, every occurrence should be counted.

A substring is a contiguous sequence of characters in a string.

Example 1:
Input: s = "xyzzaz"
Output: 1
Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz". 
The only good substring of length 3 is "xyz".

Example 2:
Input: s = "aababcabc"
Output: 4
Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
The good substrings are "abc", "bca", "cab", and "abc".

Constraints:
1 <= s.length <= 100
s​​​​​​ consists of lowercase English letters.
*/

class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        for(int i = 0 ; i < s.length() - 2 ; i++) {
            String str = s.substring(i, i+3);
            if(checkGood(str)) count++;
        }
        return count;
    }
    public boolean checkGood(String s) {
        if(s.charAt(0) == s.charAt(1) || s.charAt(0) == s.charAt(2) || s.charAt(1) == s.charAt(2)) return false;
        return true;
    }
}
