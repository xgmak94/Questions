/* https://leetcode.com/problems/add-to-array-form-of-integer/

The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

Example 1:
Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234

Example 2:
Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455

Example 3:
Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021

Constraints:
1 <= num.length <= 104
0 <= num[i] <= 9
num does not contain any leading zeros except for the zero itself.
1 <= k <= 104
Accepted
97.2K
Submissions
214.8K
*/

class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        
        int[] B = new int[String.valueOf(K).length()];
        for(int i = B.length-1 ; i >= 0 ; i--) {
            B[i] = K % 10;
            K = K/10;
        }
        
        int i = A.length-1;
        int j = B.length-1;
        int carry = 0;
        while(i >= 0 && j >= 0) {
            int sum = carry;
            if(i >= 0) sum += A[i--];
            if(j >= 0) sum += B[j--];
            carry = 0;
            
            int num = sum % 10;
            carry = sum / 10;
            list.add(0, num);
        }
        if(carry == 1) list.add(0, carry);
        return list;
    }
}
