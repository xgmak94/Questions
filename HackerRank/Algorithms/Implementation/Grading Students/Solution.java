//https://www.hackerrank.com/challenges/grading

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        for(int i = 0; i < n; i++) {
            int grade = in.nextInt();
            if(grade % 5 >= 3 && grade >= 38)
                grade = grade + (5 - (grade % 5));
            else
                grade = grade;
            System.out.println(grade);
        }
    }
}