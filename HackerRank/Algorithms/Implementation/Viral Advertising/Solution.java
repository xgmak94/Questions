// https://www.hackerrank.com/challenges/strange-advertising
// double check

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        
        int liked = 2, share = 2;
        for(int i = 1; i < n; i++) {
            liked += (share * 3) / 2;
            
            share = (share * 3) / 2;
        }
        System.out.println(liked);
    }
}