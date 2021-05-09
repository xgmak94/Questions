/* https://leetcode.com/problems/shortest-distance-to-a-character/description/

Given a string S and a character C, 
return an array of integers representing the shortest distance from the character C in the string.

Example 1:
Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
*/

class Solution {
    public int[] shortestToChar(String S, char C) {
        int n = S.length();
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(left, n);
        Arrays.fill(right, n);
        
        for(int i = 0 ; i < n ; i++) {
            char d = S.charAt(i);
            if(d == C) {
                left[i] = 0;
            }
            else if(i > 0) {
                left[i] = left[i-1] + 1;
            }
        }
        
        for(int i = n - 1 ; i >= 0 ; i--) {
            char d = S.charAt(i);
            if(d == C) {
                right[i] = 0;
            }
            else if(i < n - 1) {
                right[i] = right[i+1] + 1;
            }
        }
        
        for(int i = 0 ; i < n ; i++) {
            left[i] = Math.min(left[i], right[i]);
        }
        return left;
    }
}
