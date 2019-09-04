/* https://leetcode.com/problems/count-numbers-with-unique-digits
Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.

Example:
Given n = 2, return 91. (The answer should be the total numbers in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])

*/

//n = 1 [0,1,2,3,4,5,6,8,9] 10
//n = 2 [11,22,33,44,55,66...] 10 +9*9=91
//n = 3 10+9*9+ 9*9*8= 739
//n = 4 10+9*9+9*9*8 +9*9*8*7= 5275

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0)
            return 1;
        if(n == 1)
            return 10;

        int ret = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        
        for(int i = 2 ; i <= n && i <= 10 ; i++) {
            availableNumber *= uniqueDigits;
            ret += availableNumber;
            uniqueDigits--;
        }
        return ret;
    }
}
