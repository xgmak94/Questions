/* https://leetcode.com/problems/find-common-characters/

Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]

*/

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        int[] commonDict = makeDict(A[0]);
        
        for(int i = 1 ; i < A.length ; i++) {
            int[] currDict = makeDict(A[i]);
            
            for(int j = 0 ; j < 26 ; j++) {
                if(currDict[j] < commonDict[j]) //lower count of char j
                    commonDict[j] = currDict[j];
            }
        }
        
        for(int i = 0 ; i < 26 ; i++) {
            for(int j = 0 ; j < commonDict[i] ; j++) {
                ret.add(Character.toString((char)(i + 'a')));
            }
        }
        return ret;
    }
    
    public int[] makeDict(String s) {
        int[] dict = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            dict[s.charAt(i) - 'a']++;
        }
        return dict;
    }
}