/* https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example:
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.
*/

class Solution {
    String[] map = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length() == 0) return list;
        
        backtrack(list, "", digits, 0);
        return list;
    }
    
    public void backtrack(List<String> list, String mapping, String digits, int idx) {
        if(idx >= digits.length()) {
            list.add(mapping);
            return;
        }
        else {
            int digit = Character.getNumericValue(digits.charAt(idx));
            for(char c : map[digit].toCharArray()) {
                mapping += c;
                backtrack(list, mapping, digits, idx+1);
                mapping = mapping.substring(0, mapping.length() - 1);
            }
        }
    }
}