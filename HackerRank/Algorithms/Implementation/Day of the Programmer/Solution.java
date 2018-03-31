// https://www.hackerrank.com/challenges/day-of-the-programmer

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String solve(int year){
        String ans = "";

        if(year < 1918)
            if(year % 4 == 0)
                ans = "12.09." + year;
            else
                ans = "13.09." + year;
        else if(year > 1918)
            if(year % 400 == 0)
                ans = "12.09." + year;
            else if(year % 4 == 0 && year % 100 != 0)
                ans = "12.09." + year;
            else
                ans = "13.09." + year;
        else // it is 1918
            ans = "26.09." + year;
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        
        String result = solve(year);
        System.out.println(result);
    }
}
