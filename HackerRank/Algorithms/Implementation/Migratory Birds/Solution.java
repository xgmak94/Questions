// https://www.hackerrank.com/challenges/migratory-birds
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int[] types = new int[6]; // 0-6, but ignoring 0

        for(int i = 0; i < n; i++){
            int num = in.nextInt();
            types[num]++;
        }
        int max = 0, maxIndex = 0;
        
        for(int i = 1 ; i < 6 ; i++) {
            if(types[i] > max) {
                max = types[i];
                maxIndex = i;
            }
        }
        System.out.println(maxIndex);
    }
}
