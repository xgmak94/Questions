/* https://leetcode.com/problems/permutation-in-string/

Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
In other words, one of the first string's permutations is the substring of the second string.

Example 1:
Input: s1 = "ab" s2 = "eidbaooo"
Output: True
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input:s1= "ab" s2 = "eidboaoo"
Output: False
 
Constraints:
The input strings only contain lower case letters.
The length of both given strings is in range [1, 10,000].
*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        char[] mainStrArr = s2.toCharArray();
        
        int[] frequencyCount = new int[26];
        for(char c : s1.toCharArray()) frequencyCount[c-'a']++;\
        
        int start = 0, end = 0, match = 0;
        while(end < mainStrArr.length) {
            char c = mainStrArr[end];  
            if(frequencyCount[c-'a'] > 0) match++;
            frequencyCount[c-'a']--;
            end++;
            if(match == len1) return true;
            
            while(end - start >= len1) { //keep incrementing our window until it is as large as len1
                char temp = mainStrArr[start];
                frequencyCount[temp-'a']++;
                if(frequencyCount[temp-'a'] > 0) match--;
                
                start++;
            }
        }
        return false;
    }
}

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        char[] chars = new char[26];
        for(char c : s1.toCharArray()) {
        	chars[c-'a']++;
        }

        for(int i = 0 ; i <= len2-len1 ; i++) {
            char[] clone = chars.clone();
            if(match(clone, s2.substring(i, i+len1))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean match(char[] chars, String sub) {
    	for(int c : sub.toCharArray()) {
    		chars[c-'a']--;
    	}

    	for(int i = 0 ; i < 26 ; i++) {
    		if(chars[i] > 0) {
    			return false;
    		}
    	}
    	return true;
    }
}
