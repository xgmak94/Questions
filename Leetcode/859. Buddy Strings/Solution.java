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
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) 
        	return false;

        if(A.equals(B)) { //if same string must check that there is atleast one char that is the same to swap
            Set<Character> set = new HashSet<>();
            for(char c : A.toCharArray()) 
            	set.add(c);

            return set.size() != A.length();
        }
        
        List<Integer> dif = new ArrayList<>();
        for (int i = 0 ; i < A.length() ; i++) 
        	if (A.charAt(i) != B.charAt(i)) 
        		dif.add(i);

        //only 2 indexes in dif and they can be swapped
        return dif.size() == 2 && 
        A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && 
        A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }
}
