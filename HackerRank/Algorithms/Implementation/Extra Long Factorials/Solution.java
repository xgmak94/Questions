// https://www.hackerrank.com/challenges/extra-long-factorials

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        BigInteger factorial = BigInteger.valueOf(1); // need to do this for BigInteger
        
        for(int i = 1 ; i <= n ; i++)
            factorial = factorial.multiply(BigInteger.valueOf(i)); // need to do this for BigInteger
        
        System.out.println(factorial);
    }
}