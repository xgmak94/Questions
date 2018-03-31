// https://www.hackerrank.com/challenges/library-fine

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        
        int aDay, aMonth, aYear;
        int eDay, eMonth, eYear;
        int fine = 0;
        
        aDay = scan.nextInt();
        aMonth = scan.nextInt();
        aYear = scan.nextInt();
        // System.out.printf("%d %d %d\n", aDay, aMonth, aYear);
        
        eDay = scan.nextInt();
        eMonth = scan.nextInt();
        eYear = scan.nextInt();
        // System.out.printf("%d %d %d\n", eDay, eMonth, eYear);

        if(aYear > eYear)// returned year late
            fine = 10000;
        else if(aYear == eYear)
            if(aMonth > eMonth) // returned month late
                fine = (aMonth - eMonth) * 500;           
            else if(aMonth == eMonth)
            	if(aDay > eDay) // returned days late
                	fine = (aDay - eDay) * 15;
            
        System.out.println(fine);
    }
}