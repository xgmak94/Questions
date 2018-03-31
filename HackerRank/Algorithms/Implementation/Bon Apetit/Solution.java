// https://www.hackerrank.com/challenges/bon-appetit

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int bonAppetit(int numItems, int kNotEat, int charged, int[] ar) {
        int total = 0;
        for(int i = 0 ; i < numItems ; i++) {
            if(i != kNotEat)
                total += ar[i];
        }
        int actual = total / 2;
        return charged - actual;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numItems = in.nextInt();
        int kNotEat = in.nextInt();

        int[] ar = new int[numItems];
        for(int i = 0; i < numItems ; i++){
            ar[i] = in.nextInt();
        }

        int charged = in.nextInt();

        int result = bonAppetit(numItems, kNotEat, charged, ar);

        System.out.println((result == 0) ? "Bon Appetit" : result);

    }
}
