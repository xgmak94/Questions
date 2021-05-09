/* https://leetcode.com/problems/sort-array-by-parity/description/

Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
*/

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length - 1;
        
        while(l < r) {
            if(A[l] % 2 == 0) { //left val is even
                l++;
            }
            else {
                if(A[r] % 2 == 0) {
                    int temp = A[l];
                    A[l] = A[r];
                    A[r] = temp;

                    l++;
                    r--;
                }
                else {
                    r--;
                }
            }
        }
        return A;
    }
}

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int l = 0;
        int r = A.length - 1;
        
        while(l < r) {
            if(A[l] % 2 == 1) { //if odd value we move it to the back
                int temp = A[l];
                A[l] = A[r];
                A[r] = temp;
                r--;
            }
            else {
                l++;
            }
        }
        return A;
    }
}

class Solution {
    public int[] sortArrayByParity(int[] A) {
        int j = A.length - 1;
        for(int i = 0 ; i < j ; i++) {
            if(A[i] % 2 == 1) { //swap and check current index again
                int temp = A[i];	
                A[i--] = A[j];
                A[j--] = temp;
            }
        }
        return A;
    }
}
