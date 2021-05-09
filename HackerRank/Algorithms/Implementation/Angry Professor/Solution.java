// https://www.hackerrank.com/challenges/angry-professor

import java.io.*;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for(int i = 0 ; i < t ; i++) {
            int nStudents = scan.nextInt();
            int kCancel = scan.nextInt();
            
            for(int j = 0 ; j < nStudents ; j++) {
                int time = scan.nextInt();
                if(time <= 0)
                    kCancel--; //if he wants n students then when n students come in on time <= 0 not canceled
            }
            if(kCancel <= 0)
                System.out.println("NO");
            else
                System.out.println("YES");
        }
    }
}