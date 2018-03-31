// https://www.hackerrank.com/challenges/beautiful-days-at-the-movies

import java.io.*;
import java.util.*;

public class Solution {

    static int reverse(int a) {
        StringBuilder newString = new StringBuilder();
        newString.append(a);
        newString = newString.reverse();

        String temp = newString.toString();            
        int reversed = Integer.parseInt(temp);
        
        return reversed;
    }
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();
        
        int k = scan.nextInt();
        
        int beautifulDays = 0;
        for(int i = start ; i <= end ; i++) {          
            int reversed = reverse(i);
            
            int absDifference = Math.abs(reversed - i);
            if(absDifference % k == 0)
                beautifulDays++;
        }
        System.out.println(beautifulDays);
    }
}