/* https://leetcode.com/problems/implement-strstr/description/

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/

class Solution {
    public int strStr(String s, String t) {
        if (t.length == 0) 
            return 0; // edge case: "",""=>0  "a",""=>0
        
        for (int i = 0 ; i < s.length() - t.length() + 1 ; i++) {
            for (int j = 0; j < t.length() && s.charAt(i + j) == t.charAt(j); j++)
                if (j == t.length() - 1) 
                    return i;
        }
        return -1;
    }
}
