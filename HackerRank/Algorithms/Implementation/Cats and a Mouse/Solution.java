// https://www.hackerrank.com/challenges/cats-and-a-mouse

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static String solve(int a, int b, int mouse) {
        String ans = "";
        int aDistance = Math.abs(a - mouse);
        int bDistance = Math.abs(b - mouse);
        
        if(aDistance < bDistance)
            ans = "Cat A";
        else if(bDistance < aDistance)
            ans = "Cat B";
        else
            ans = "Mouse C";
        
        return ans;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ; i < n ; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int mouse = in.nextInt();
            
            String ans = solve(a, b, mouse);
            System.out.println(ans);
        }
    }
}