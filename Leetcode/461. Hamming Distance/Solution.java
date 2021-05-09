// https://leetcode.com/problems/hamming-distance

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
*/

public class Solution {
    public int hammingDistance(int x, int y) { 
        int z = x ^ y; // when we ^,xor, returns 1 if both bits are different
        return Integer.bitCount(z);
    }
}
