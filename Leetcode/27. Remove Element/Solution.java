// https://leetcode.com/problems/remove-element

/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public int removeElement(int[] A, int elem) {
       int idx = 0;    
       for(int i = 0; i < A.length; i++){
           if(A[i] != elem){
               A[idx] = A[i];
               idx++;
           }
       }
       return idx;
    }
}
