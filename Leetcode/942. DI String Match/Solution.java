/* https://leetcode.com/problems/di-string-match/

Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]

*/

class Solution {
    public int[] diStringMatch(String S) {
        int n = S.length();
        int[] res = new int[n+1];
        int low = 0, high = n;
        for(int i = 0 ; i < n ; i++) {
            res[i] = S.charAt(i) == 'I' ? low++ : high--;
        }
        res[n] = high;
        return res;
    }
}
