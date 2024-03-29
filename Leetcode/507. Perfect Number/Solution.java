/* https://leetcode.com/problems/perfect-number/

We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
Example:
Input: 28
Output: True
Explanation: 28 = 1 + 2 + 4 + 7 + 14
*/

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        
        int sum = 1; // 1 is always a divisor
        for(int i = 2 ; i <= Math.sqrt(num) ; i++) { //we will get all divisors from less than square
            if(num % i == 0) {
                sum += i; //divisor
                sum += num/i; //other divisor
                if(i * i == num) { // squared only count once
                    sum -= i;
                }
            }
        }
        return sum == num;
    }
}
