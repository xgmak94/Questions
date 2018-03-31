// https://www.hackerrank.com/challenges/sock-merchant

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] types = new int[101]; // 1 - 100 
        for(int i = 0; i < n; i++)
        	types[in.nextInt()]++;

        int pairs = 0;
        for(int i = 1 ; i < 101 ; i++)
            pairs += (types[i] / 2);

        System.out.println(pairs);
    }
}
