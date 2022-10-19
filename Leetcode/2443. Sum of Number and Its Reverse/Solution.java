/* https://leetcode.com/problems/sum-of-number-and-its-reverse/

Given a non-negative integer num, return true if num can be expressed as the sum of any non-negative integer and its reverse, or false otherwise.

Example 1:
Input: num = 443
Output: true
Explanation: 172 + 271 = 443 so we return true.

Example 2:
Input: num = 63
Output: false
Explanation: 63 cannot be expressed as the sum of a non-negative integer and its reverse so we return false.

Example 3:
Input: num = 181
Output: true
Explanation: 140 + 041 = 181 so we return true. Note that when a number is reversed, there may be leading zeros.

Constraints:
0 <= num <= 105
*/

class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i = 0 ; i <= num ; i++) {
            if(i + reverse(i) == num){
                return true;
            }
        }
        return false;
    }
    
    public int reverse(int num) {
        int rev = 0;
        
        while(num > 0) {
            rev = rev*10 + num % 10;
            num = num/10;
        }
        return rev;
    }
}
