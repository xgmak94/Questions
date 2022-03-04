/* https://leetcode.com/problems/custom-sort-string/

S and T are strings composed of lowercase letters. In S, no letter occurs more than once.

S was sorted in some custom order previously. We want to permute the characters of T so that they match the order that S was sorted. More specifically, if x occurs before y in S, then x should occur before y in the returned string.

Return any permutation of T (as a string) that satisfies this property.

Example :
Input: 
S = "cba"
T = "abcd"
Output: "cbad"
Explanation: 
"a", "b", "c" appear in S, so the order of "a", "b", "c" should be "c", "b", and "a". 
Since "d" does not appear in S, it can be at any position in T. "dcba", "cdba", "cbda" are also valid outputs.
*/

class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        
        for(char c : s.toCharArray()) {
            count[c-'a']++;
        }
        
        for(char d : order.toCharArray()) {
            while(count[d-'a']-- > 0) {
                sb.append(d);
            }
        }
        
        for(char c = 'a' ; c <= 'z' ; c++) {
            while(count[c-'a']-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
