// https://www.hackerrank.com/challenges/electronics-shop

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int getMoneySpent(int[] keyboards, int[] drives, int money){
        int max = -1;
        for(int i = 0 ; i < keyboards.length ; i++)
            for(int j = 0 ; j < drives.length ; j++) {          
                int sum = keyboards[i] + drives[j];
                if(sum > max && sum <= money)
                    max = sum;
            }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int money = in.nextInt();
        int nItems = in.nextInt();
        int mItems = in.nextInt();

        int[] keyboards = new int[nItems];
        for(int i = 0 ; i < nItems ; i++)
            keyboards[i] = in.nextInt();

        int[] drives = new int[mItems];
        for(int j = 0; j < mItems; j++)
            drives[j] = in.nextInt();

        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, money);
        System.out.println(moneySpent);
    }
}
