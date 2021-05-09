/* https://leetcode.com/problems/maximum-score-after-splitting-a-string/

Given a string s of zeros and ones, return the maximum score after splitting the string into two non-empty substrings (i.e. left substring and right substring).

The score after splitting a string is the number of zeros in the left substring plus the number of ones in the right substring.

Example 1:
Input: s = "011101"
Output: 5 
Explanation: 
All possible ways of splitting s into two non-empty substrings are:
left = "0" and right = "11101", score = 1 + 4 = 5 
left = "01" and right = "1101", score = 1 + 3 = 4 
left = "011" and right = "101", score = 1 + 2 = 3 
left = "0111" and right = "01", score = 1 + 1 = 2 
left = "01110" and right = "1", score = 2 + 1 = 3

Example 2:
Input: s = "00111"
Output: 5
Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5

Example 3:
Input: s = "1111"
Output: 3
*/

class Solution {
    public int maxScore(String s) {
        int len = s.length();
        int[] countZeros = new int[len];
        int[] countOnes = new int[len];
        Arrays.fill(countZeros, 0);
        Arrays.fill(countOnes, 0);
                
        if(s.charAt(0) == '0') countZeros[0] = 1;
        for(int i = 1 ; i < len ; i++) {
            char c = s.charAt(i);
            countZeros[i] = countZeros[i-1];
            if(c == '0') countZeros[i] += 1;
        }
        
        if(s.charAt(len-1) == '1') countOnes[len-1] = 1;
        for(int i = len-2 ; i >= 0 ; i--) {
            char c = s.charAt(i);
            countOnes[i] = countOnes[i+1];
            if(c == '1') countOnes[i] += 1;
        }
        
        int maxScore = 0;
        for(int i = 0 ; i < len-1 ; i++) {
            int score = countZeros[i] + countOnes[i+1];
            
            maxScore = Math.max(score, maxScore);
        }
        return maxScore;
    }
}
