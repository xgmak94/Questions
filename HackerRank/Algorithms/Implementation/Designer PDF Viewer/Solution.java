//https://www.hackerrank.com/challenges/designer-pdf-viewer

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 26;
        int[] h = new int[n];
        for(int i = 0; i < n; i++)
            h[i] = in.nextInt();
        
        String word = in.next();
        
        int maxHeight = 0;
        
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(maxHeight < h[c - 'a'])
                maxHeight = h[c - 'a'];
        }
        
        System.out.println(word.length() * maxHeight);
    }
}
