// https://www.hackerrank.com/challenges/repeated-string

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        
        long completeStrings = n / s.length();
        long extraStrings = n % s.length();
        
        int countA = s.length() - s.replaceAll("a", "").length();
        
        int extra = 0;
        for(int i = 0 ; i < extraStrings ; i++) {
            if(s.charAt(i) == 'a')
                extra++;

        System.out.println(completeStrings*countA + extra);
            
    }
}