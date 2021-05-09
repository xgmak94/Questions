// https://www.hackerrank.com/challenges/divisible-sum-pairs

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int divisible = in.nextInt();
        
        int[] ar = new int[n];
        for(int i = 0; i < n; i++){
            ar[i] = in.nextInt();
        }
        
        int count = 0;
        
        for(int i = 0 ; i < n - 1 ; i++)
            for(int j = i + 1 ; j < n ; j++)
                if((ar[i] + ar[j]) % divisible == 0)
                    count++;
        
        System.out.println(count);
    }
}
