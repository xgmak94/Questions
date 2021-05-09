// https://www.hackerrank.com/challenges/the-birthday-bar

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[] squares = new int[n];
        for(int i = 0; i < n; i++)
            squares[i] = in.nextInt();
        
        int day = in.nextInt();
        int month = in.nextInt();
        
        int count = 0;
        
        for(int i = 0 ; i < n - month + 1 ; i++) {
            int j = 0, sum = 0;
            while(j != month) {
                sum += squares[i + j];
                j++;
            }
            if(sum == day)
                count++;
        }
        System.out.println(count);
    }
}