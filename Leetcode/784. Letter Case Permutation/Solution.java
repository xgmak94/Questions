/* https://leetcode.com/problems/letter-case-permutation/

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
*/

class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        
        permutate(S, "", list, 0);
        return list;
    }
    
    public void permutate(String s, String curr, List<String> list, int idx) {        
        for(int i = idx ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(Character.isLetter(c)) {
                curr += Character.toLowerCase(c);
                
                permutate(s, curr, list, i+1);
                
                curr = curr.substring(0, curr.length()-1);
                curr += Character.toUpperCase(c);
            }
            else {
                curr += c;
            }
        }
        list.add(curr);
    }
}
