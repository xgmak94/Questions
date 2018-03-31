// https://www.hackerrank.com/challenges/apple-and-orange

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int start = in.nextInt();
        int end = in.nextInt();
        
        int apple = in.nextInt();
        int orange = in.nextInt();
        
        int mApples = in.nextInt();
        int nOranges = in.nextInt();
              
        int appleHit = 0, orangeHit = 0;
        
        for(int i = 0; i < mApples; i++){
            int landed = apple + in.nextInt();
            if(landed >= start && landed <= end)
                appleHit++;
        }

        for(int j = 0; j < nOranges; j++){
            int landed = orange + in.nextInt();
            if(landed >= start && landed <= end)
                orangeHit++;
        }
        
        System.out.printf("%d\n%d\n", appleHit, orangeHit);
    }
}