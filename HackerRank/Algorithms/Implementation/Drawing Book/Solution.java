// https://www.hackerrank.com/challenges/drawing-book

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int solve(int n, int p){
        int fromFront = p / 2;
        int fromBack = n / 2 - p / 2;
        
        return (fromFront < fromBack) ? fromFront : fromBack;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        
        int result = solve(n, p);
        System.out.println(result);
    }
}
