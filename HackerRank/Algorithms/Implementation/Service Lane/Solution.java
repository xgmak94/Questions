// https://www.hackerrank.com/challenges/service-lane
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int t = scan.nextInt();
        
        int[] freeway = new int[n];
        for(int i = 0 ; i < n ; i++)
            freeway[i] = scan.nextInt();
        
        for(int i = 0 ; i < t ; i++) {
            int min = Integer.MAX_VALUE ;
            int start = scan.nextInt();
            int end = scan.nextInt();
                        
            for(int j = start ; j <= end ; j++) {
                if(freeway[j] < min)
                    min = freeway[j];
            }
            System.out.println(min);
        }
    }
}