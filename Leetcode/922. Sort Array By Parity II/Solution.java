/* https://leetcode.com/problems/sort-array-by-parity-ii/

Given an array of integers nums, half of the integers in nums are odd, and the other half are even.

Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.

Return any answer array that satisfies this condition.

Example 1:
Input: nums = [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Example 2:
Input: nums = [2,3]
Output: [2,3]

Constraints:
2 <= nums.length <= 2 * 104
nums.length is even.
Half of the integers in nums are even.
0 <= nums[i] <= 1000
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
