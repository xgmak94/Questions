/* https://leetcode.com/problems/add-to-array-form-of-integer/

For a non-negative integer X, the array-form of X is an array of its digits in left to right order.  For example, if X = 1231, then the array form is [1,2,3,1].

Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.

Example 1:
Input: A = [1,2,0,0], K = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:
Input: A = [2,7,4], K = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455

Example 3:
Input: A = [2,1,5], K = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021

Example 4:
Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
Output: [1,0,0,0,0,0,0,0,0,0,0]
Explanation: 9999999999 + 1 = 10000000000
*/

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        
        int[] B = new int[String.valueOf(K).length()];
        for(int i = B.length-1 ; i >= 0 ; i--) {
            B[i] = K % 10;
            K = K/10;
        }
        
        int i = A.length-1, j = B.length-1;
        int carry = 0;
        
        while(i >= 0 && j >= 0) {
            int sum = A[i--] + B[j--] + carry;
            carry = 0;
            
            int num = sum % 10;
            carry = sum / 10;
            list.add(0, num);
        }
        
        while(i >= 0) {
            int sum = A[i--] + carry;
            carry = 0;
            
            int num = sum % 10;
            carry = sum / 10;
            list.add(0, num);
        }
        while(j >= 0) {
            int sum = B[j--] + carry;
            carry = 0;
            
            int num = sum % 10;
            carry = sum / 10;
            list.add(0, num);
        }
        
        if(carry == 1) list.add(0, carry);
        return list;
    }
}
