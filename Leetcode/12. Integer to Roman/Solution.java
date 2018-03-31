/* https://leetcode.com/problems/integer-to-roman/description/

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

*/

class Solution {
    public String intToRoman(int num) {
        // 1 to 3999
        String[] thousand   = {"", "M", "MM", "MMM"};
        String[] hundred    = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] ten        = {"","X","XX","XXX","XL","L","LX","LXX","LXXX", "XC"};
        String[] single     = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        
        return thousand[num/1000] + hundred[(num%1000)/100] + ten[(num%100)/10] + single[num%10];
    }
}