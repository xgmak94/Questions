// https://www.hackerrank.com/challenges/circular-array-rotation

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int rotations = in.nextInt();
        int queries = in.nextInt();
        
        int[] init = new int[n];
        for(int i = 0 ; i < n ; i++)
            init[i] = in.nextInt();
        
        for(int j = 0 ; j < queries ; j++){
            int index = in.nextInt();
            System.out.println(init[(index - rotations + n) % n]);
        }
    }
}
