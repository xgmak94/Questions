/* https://leetcode.com/problems/buddy-strings/

Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.

Example 1:
Input: A = "ab", B = "ba"
Output: true

Example 2:
Input: A = "ab", B = "ab"
Output: false

Example 3:
Input: A = "aa", B = "aa"
Output: true

Example 4:
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true

Example 5:
Input: A = "", B = "aa"
Output: false
 
Note:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist only of lowercase letters.
*/

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) return false;

        if(s.equals(goal)) { //if same string must check that there is atleast one char that is the same to swap
            Set<Character> set = new HashSet<>();
            for(char c : s.toCharArray()) {
                if(set.contains(c)) {
                    return true;
                }
                else {
                    set.add(c);
                }
            }
            return false;
        }
        
        List<Integer> diff = new ArrayList<>();
        for (int i = 0 ; i < s.length() ; i++) {
        	if (s.charAt(i) != goal.charAt(i)) {
        		diff.add(i);
            }
        }

        //only 2 indexes in diff and they can be swapped
        return diff.size() == 2 && 
            s.charAt(diff.get(0)) == goal.charAt(diff.get(1)) && 
            s.charAt(diff.get(1)) == goal.charAt(diff.get(0));
    }
}
