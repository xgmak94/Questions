/* https://leetcode.com/problems/add-digits
Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

For example:

Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
*/

public class Solution {
    public int addDigits(int num) {
    	int sum = 0;
        if(num < 10)
            return num;
        
        while(num >= 10) {
            sum += num % 10;
            num = num / 10;
            
            if(num <= 11 && sum != 0) {
                sum += num;
                num = sum;
                sum = 0;
            }
        }
        return num;
    }
}
