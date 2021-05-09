/* https://leetcode.com/problems/max-consecutive-ones-iii/

Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

Example 1:
Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
Output: 6
Explanation: 
[1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

Example 2:
Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
Output: 10
Explanation: 
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 
Note:
1 <= A.length <= 20000
0 <= K <= A.length
A[i] is 0 or 1 
*/

class Solution {
    public int longestOnes(int[] A, int K) {
        int l = 0;
        int r = 0;
        int longest = 0;
        int zeroCount = 0;
        
        while(r < A.length) {
            if(A[r] == 0) zeroCount++;

            while(zeroCount > K) { //if we have more zeros than allowed, we need to remove a zero from left
                if(A[l] == 0) zeroCount--;
                l++;
            }
            longest = Math.max(longest, r-l+1);
            r++;
        }
        return longest;
    }
}