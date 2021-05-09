// https://www.hackerrank.com/challenges/breaking-best-and-worst-records

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        int firstScore = in.nextInt();
        int highScore = firstScore, lowScore = firstScore;
        
        int high = 0, low = 0;
        for(int i = 1; i < n; i++){
            int score = in.nextInt();
            if(score > highScore) {
                highScore = score;
                high++;
            }
            else if(score < lowScore) {
                lowScore = score;
                low++;
            }
        }
        System.out.printf("%d %d\n", high, low);
    }
}