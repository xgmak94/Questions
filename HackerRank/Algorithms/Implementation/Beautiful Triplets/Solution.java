//https://www.hackerrank.com/challenges/beautiful-triplets

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int d = scan.nextInt();
        
        Integer[] values = new Integer[n];
        
        for(int i = 0 ; i < n ; i++)
            values[i] = scan.nextInt();
        
        List<Integer> valuesList = new ArrayList<Integer>(Arrays.asList(values));

        int numBeautiful = 0;
        for(int i = 0 ; i < n ; i++)
            if(valuesList.contains(values[i] + d) && valuesList.contains(values[i] + (2 * d)))
                numBeautiful++;

        System.out.println(numBeautiful);
    }
}