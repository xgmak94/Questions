/*
Given two input integers a and b, write a method to determine the number of bits required to be swapped to convert a to b.

Example:

a = 21, Binary code = 10101
b = 31, Binary code = 11111
bitSwapRequired(a,b) --> 2
*/

public int bitSwapRequired(int a, int b) {
        int c = a ^ b;
        return Integer.bitCount(c);
}