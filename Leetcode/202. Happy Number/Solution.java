/* https://leetcode.com/problems/happy-number/

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: 

Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. 
Those numbers for which this process ends in 1 are happy numbers.

Example: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>(); //check if looping
        
        while(set.add(n)) { //can be added to set means its not a loop yet
            n = squareDigits(n);
            
            if(n == 1) { //happy if the number is 1
                return true;
            }
        }
        return false; //if we looped its false
    }

    public int squareDigits(int n) {
        int sum = 0;
        while(n > 0) {
            int digit = n % 10;
            sum += (digit*digit);
            n = n / 10;
        }
        return sum;
    }
}
