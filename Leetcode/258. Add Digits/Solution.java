/* https://leetcode.com/problems/add-digits

Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/

class Solution {
    public int addDigits(int num) {
        int sum = 0;
        
        while(num >= 10) {
            sum += num % 10;
            num /= 10;
            
            if(num < 10 && sum != 0) { //if out of digits, replace the num with sum
                sum += num; //add last digit
                num = sum; //replace
                sum = 0; //reset
            }
        }
        return num;
    }
}
