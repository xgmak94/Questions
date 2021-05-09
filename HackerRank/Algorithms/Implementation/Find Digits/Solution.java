// https://www.hackerrank.com/challenges/find-digits

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for(int i = 0 ; i < t ; i++) {
            int number = scan.nextInt();
            
            String stringNumber = String.valueOf(number);
            char[] digits = stringNumber.toCharArray(); // convert number to char array containing each digit
            
            int numDivide = 0;
            for(int j = 0 ; j < digits.length ; j++) {
                int digit = Character.getNumericValue(digits[j]); // convert char array of digits to integers
                if(digit == 0)
                    continue;
                if(number % digit == 0)
                    numDivide++;
            }
            System.out.println(numDivide);
        }
    }
}	