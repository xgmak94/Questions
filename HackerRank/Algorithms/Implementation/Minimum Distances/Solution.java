// https://www.hackerrank.com/challenges/minimum-distances

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] values = new int[n];
        for(int i = 0 ; i < n ; i++)
            values[i] = in.nextInt();
        
        int difference = Integer.MAX_VALUE;

        for(int i = 0 ; i < n - 1 ; i++)
            for(int j = i + 1 ; j < n ; j++)
                if(values[i] == values[j])
                    difference = ((j-i) < difference) ? (j - i) : difference;

        difference = (difference == Integer.MAX_VALUE) ? -1 : difference;
        System.out.println(difference);
    }
}
