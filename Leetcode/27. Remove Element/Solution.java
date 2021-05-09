/* https://leetcode.com/problems/remove-element

Given an array and a value, remove all instances of that value in place and return the new length.
Do not allocate extra space for another array, you must do this in place with constant memory.
The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

class Solution {
    public int removeElement(int[] A, int target) {
       int idx = 0;    
       for(int i = 0; i < A.length; i++){
           if(A[i] != target) { //add all elements that are not the target to the front
               A[idx] = A[i];
               idx++;
           }
       }
       return idx;
    }
}
