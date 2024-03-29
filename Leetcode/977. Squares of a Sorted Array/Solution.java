/* https://leetcode.com/problems/squares-of-a-sorted-array/

Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] squares = new int[nums.length];
        
        int l = 0;
        int r = nums.length-1;
        int idx = nums.length-1;
        while(l <= r) {
            if(nums[l]*nums[l] > nums[r]*nums[r]) {
                squares[idx] = nums[l]*nums[l];
                idx--;
                l++;
            }
            else {
                squares[idx] = nums[r]*nums[r];
                idx--;
                r--;
            }
        }
        return squares;
    }
}

class Solution {
    public int[] sortedSquares(int[] A) {
        int[] squares = new int[A.length];
        int n = A.length;
        int j = 0;
        
        while(j < n && A[j] < 0)
            j++;
        
        int i = j - 1;
        int idx = 0;
        
        while(i >= 0 && j < n) {
            if(A[i]*A[i] < A[j]*A[j]) {
                squares[idx] = A[i]*A[i];
                i--;
            }
            else {
                squares[idx] = A[j]*A[j];
                j++;
            }
            idx++;
        }
        
        while(i >= 0) {
            squares[idx] = A[i]*A[i];
            idx++;
            i--;
        }
        while(j < n) {
            squares[idx] = A[j]*A[j];
            idx++;
            j++;
        }
        return squares;
    }
}



class Solution {
    public int[] sortedSquares(int[] A) {
        int[] squared = new int[A.length];
        
        for(int i = 0 ; i < A.length ; i++) {
            squared[i] = A[i]*A[i];
        }
        
        Arrays.sort(squared);
        
        return squared;
    }
}
