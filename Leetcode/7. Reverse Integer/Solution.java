/* https://leetcode.com/problems/reverse-integer/

Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

class Solution {
    public int reverse(int x) {
        long reversed = 0;
        while(x != 0) {
            reversed = reversed*10 + x % 10;
            x = x/10;
            
            if(reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) { //overlow or underflow
                return 0;
            }
        }
        return (int)reversed;
    }
}
