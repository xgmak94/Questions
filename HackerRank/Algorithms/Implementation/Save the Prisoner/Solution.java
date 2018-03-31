// https://www.hackerrank.com/challenges/save-the-prisoner

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static int saveThePrisoner(int nPrisoners, int mChoclates, int start){
        return ((start - 1 + mChoclates - 1) % nPrisoners) + 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t ; i++){
            int nPrisoners = in.nextInt();
            int mChoclates = in.nextInt();
            int start = in.nextInt();
            
            int result = saveThePrisoner(nPrisoners, mChoclates, start);
            System.out.println(result);
        }
    }
}
