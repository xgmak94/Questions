/* https://leetcode.com/problems/find-all-anagrams-in-a-string/

Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]

Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:
Input:
s: "abab" p: "ab"
Output:
[0, 1, 2]

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".
*/

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        char[] chars = new char[26];
        for(char c : p.toCharArray()) { //the anagram we are looking for
            chars[c-'a']++;
        }
        
        int start = 0, end = 0, match = 0;
        while(end < s.length()) {
            char c = s.charAt(end++);
            if(chars[c-'a'] > 0) match++;
            chars[c-'a']--;
            if(match == p.length()) list.add(start);
            
            while(end - start >= p.length()) { // make sure window is as long as string length
                char temp = s.charAt(start++);
                chars[temp-'a']++; //add back the character to frequency
                if(chars[temp-'a'] > 0) match--; //unmatch it
            }
        }
        return list;
    }
}
