/* https://leetcode.com/problems/valid-perfect-square/

Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:
Input: 16
Returns: True

Example 2:
Input: 14
Returns: False
*/

//square numbers
//1
//4 = 1+3
//9 = 1+3+5
//16 = 1+3+5+7
//25 = 1+3+5+7+9
class Solution {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while(num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}

class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        
        int square = 0;
        for(int i = 1 ; i < num ; i += 2) {
            square += i;
            if(square == num)
                return true;
        }
        return false;
    }
}