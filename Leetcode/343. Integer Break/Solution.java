/* https://leetcode.com/problems/integer-break/

Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. 
Return the maximum product you can get.

For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

Note: You may assume that n is not less than 2 and not larger than 58.
*/

//math says factors of 2 and 3 are best
class Solution {
    public int integerBreak(int n) {
        if(n == 2) //1+1
            return 1;
        if(n == 3) //2+1
            return 2;
        
        int product = 1;
        while(n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
            
        return product;
    }
}
