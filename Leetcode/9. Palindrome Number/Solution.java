/* https://leetcode.com/problems/palindrome-number/description/

Determine whether an integer is a palindrome. Do this without extra space.

*/

class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0)
            return true;
        if(x < 0 || x % 10 == 0)
            return false;
        
        int reversed = 0;
        
        while(x > reversed) {
            reversed = reversed*10 + (x % 10);
            x = x/10;
        }
        return reversed == x || reversed/10 == x;
    }
}