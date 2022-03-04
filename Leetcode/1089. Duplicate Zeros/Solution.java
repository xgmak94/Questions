/* https://leetcode.com/problems/duplicate-zeros/

Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.

Note that elements beyond the length of the original array are not written.

Do the above modifications to the input array in place, do not return anything from your function.

Example 1:
Input: [1,0,2,3,0,4,5,0]
Output: null
Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]

Example 2:
Input: [1,2,3]
Output: null
Explanation: After calling your function, the input array is modified to: [1,2,3]
*/

class Solution {
    public void duplicateZeros(int[] arr) {
        int numZeros = 0;
        for(int num : arr) {
            if(num == 0) numZeros++;
        }
        int newLen = arr.length+numZeros;

        int i = arr.length-1;
        int j = newLen-1;
        while(j >= 0) {
            if(arr[i] == 0) { //if we hit a zero copy it twice
                if(j < arr.length) arr[j] = arr[i]; //only need to write if within original arr bounds
                j--;
                if(j < arr.length) arr[j] = arr[i]; //only need to write if within original arr bounds
            }
            else { // non-zero copy once
                if(j < arr.length) arr[j] = arr[i]; //only need to write if within original arr bounds
            }
            i--;
            j--;
        }
    }
}
