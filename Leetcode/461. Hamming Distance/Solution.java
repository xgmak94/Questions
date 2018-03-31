// https://leetcode.com/problems/hamming-distance

/*
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
*/

import java.io.*;
import java.util.*;

public class Solution {
    public int hammingDistance(int x, int y) { 
        int z = x ^ y; // when we xor two bits output 1 only if both were 1
        return Integer.bitCount(z);
    }
}
