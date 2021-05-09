/* https://leetcode.com/problems/rotated-digits/

X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other (on this case they are rotated in a different direction, in other words 2 or 5 gets mirrored); 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

Now given a positive number N, how many numbers X from 1 to N are good?

Example:
Input: 10
Output: 4
Explanation: 
There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
Note:

N  will be in range [1, 10000].
*/

class Solution {
    public int rotatedDigits(int N) {
        int count = 0;
        for(int i = 1 ; i <= N ; i++) {
            if(valid(i)) count++;
        }
        return count;
    }
    
    public boolean valid(int N) {
        boolean isValid = false;
        
        while(N > 0) {
            int digit = N % 10;
            //1,2,8 must have one of these digits to be valid
            if(digit == 2 || digit == 5) isValid = true;
            if(digit == 6 || digit == 9) isValid = true;
            if(digit == 3 || digit == 4 || digit == 7) return false; 
            N = N/10;
        }
        return isValid;
    }
}
