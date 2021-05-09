/* https://leetcode.com/problems/valid-mountain-array/

Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]
A[i] > A[i+1] > ... > A[B.length - 1]
 
Example 1:
Input: [2,1]
Output: false

Example 2:
Input: [3,5,5]
Output: false

Example 3:
Input: [0,3,2,1]
Output: true
*/

class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        int i = 0, j = n-1;
        
        while(i+1 < n && A[i] < A[i+1]) {
            i++;
        }
        while(j-1 >= 0 && A[j-1] > A[j]) {
            j--;
        }
        return (i > 0 && j < n-1) && i == j; //not on edge
    }
}

class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        int i = 0;
        
        while(i+1 < n && A[i] < A[i+1]) // increment until next element is decreasing/equal
            i++;
        
        if(i == 0 || i == n-1) //first or last is invalid to be considered a mountain
            return false;
        
        while(i+1 < n && A[i] > A[i+1]) // increment until end of array or next element is increasing/equal
            i++;
        
        return i == n-1;
    }
}
