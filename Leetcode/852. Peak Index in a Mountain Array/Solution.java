/* https://leetcode.com/problems/peak-index-in-a-mountain-array/description/

Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].

*/

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        for(int i = 1 ; i < A.length - 1 ; i++) {
            if(A[i-1] < A[i] && A[i] > A[i+1])
                return i;
        }
        return -1;
    }
}
