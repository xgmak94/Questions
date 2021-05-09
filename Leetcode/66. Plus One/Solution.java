/* https://leetcode.com/problems/plus-one/description/

Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

class Solution {
    public int[] plusOne(int[] digits) {          
        int carry = 1;        
        for(int i = digits.length - 1 ; i >= 0 ; i--) {
            int sum = digits[i] + carry;
            digits[i] = sum % 10;
            carry = sum / 10;
        }
        
        if(carry == 1) { //EX. 999+1
            int[] num = new int[digits.length + 1];
            num[0] = 1;
            for(int i = 1 ; i < digits.length + 1 ; i++) {
                num[i]= digits[i-1];
            }
            return num;
        }
        else {
            return digits;
        }
    }
}

public class Solution {
    public int[] plusOne(int[] num) {
        int[] digits = num.clone();
        int length = digits.length;
        
        boolean carry = false;
        
        digits[length - 1] += 1;
        for(int i = length - 1 ; i >= 0 ; i--) {
            if(carry)
                digits[i]++;
            
            if(digits[i] > 9) {
                digits[i] -= 10;
                carry = true;
            }
            else {
                carry = false;
            }
        }
        
        if (digits[0] == 0) {
            int[] res = new int[length + 1];
            res[0] = 1;
            for(int i = 0 ; i < length ; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
     
        return digits;
    }
}