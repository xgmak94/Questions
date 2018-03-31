// https://www.hackerrank.com/challenges/the-hurdle-race

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        int max = 0;
        
        for(int i = 0 ; i < n ; i++){
            int num = in.nextInt();
            if(num > max)
                max = num;
        }
        
        System.out.println((max-k > 0) ? max - k : 0);
    }
}
