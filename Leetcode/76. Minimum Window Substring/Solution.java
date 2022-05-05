/* https://leetcode.com/problems/minimum-window-substring/

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"

Note:
If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.
*/

class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() < t.length() || s.length() == 0) return "";

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0; int r = 0;
        int minleft = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        while(r < s.length()) {
            char rChar = s.charAt(r);
            if(map.containsKey(rChar)) {
                map.put(rChar,map.get(rChar)-1);
                if(map.get(rChar) >= 0) count++;
                
                while(count == t.length()) {
                    char lChar = s.charAt(l);
                    int len = r-l+1;
                    if(len < minLen) {
                        minleft = l;
                        minLen = len;
                    }
                    if(map.containsKey(lChar)) {
                        map.put(lChar, map.get(lChar)+1);
                        if(map.get(lChar) > 0) {
                            count--;
                        }
                    }
                    l++;
                }
            }
            r++;
        }
        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(minleft, minleft + minLen);
        // if(minLen>s.length()) return ""; //did not find a matching substring
        // return s.substring(minl,minl+minLen);
    }
}
