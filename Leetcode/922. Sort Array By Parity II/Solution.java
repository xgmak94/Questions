/* https://leetcode.com/problems/sort-array-by-parity-ii/description/

Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.

Example 1:
Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
*/

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int oddIndex = 1;
        int evenIndex = 0;
        
        while(evenIndex < A.length) {
            while(A[evenIndex] % 2 != 0) { //if this evenindex is an odd vavl
                if(A[oddIndex] % 2 == 0) { //find next oddindex to swap
                    swap(A, oddIndex, evenIndex);
                }
                else {
                    oddIndex += 2;
                }
            }
            evenIndex += 2;
        }
        return A;
    }
    
    public void swap(int[] A, int x, int y) {
        int temp = A[x];
        A[x] = A[y];
        A[y] = temp;
    }
}

class Solution {
    public int[] sortArrayByParityII(int[] A) {
        for(int i = 0, j = 1 ; i < A.length ; i += 2) {
            if(A[i] % 2 == 1) { //if even index has odd value
                while(A[j] % 2 == 1 && j < A.length) { //find next odd index with even value
                    j += 2;
                }
                swap(A, i, j);
                j += 2;
            }
        }
        return A;
    }

    public void swap(int[] A, int i, int j) {
    	int temp = A[i];
    	A[i] = A[j];
    	A[j] = temp;
    }
}
