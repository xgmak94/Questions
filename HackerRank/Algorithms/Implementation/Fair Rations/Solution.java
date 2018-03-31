// https://www.hackerrank.com/challenges/fair-rations

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int ration(int[] bread, int n) {
        int distributed = 0;
        for(int i = 0 ; i < n - 1 ; i++) {
            if(bread[i] % 2 == 1) {
                bread[i]++;
                bread[i + 1]++;
                distributed += 2;
            }
        }
        return distributed;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] bread = new int[n];
        int totalBread = 0;
        for(int i = 0 ; i < n ; i++){
            bread[i] = in.nextInt();
            totalBread += bread[i];
        }
        
        if(totalBread % 2 == 1) { // if rations are odd already it is not possible to make it even if we must distribute 2 at a time
            System.out.println("NO");
        }
        else {
            int distributed = ration(bread, n);
            System.out.println(distributed);
        } 
    }
}
