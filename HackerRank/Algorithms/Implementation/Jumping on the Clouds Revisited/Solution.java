// https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int clouds[] = new int[n];
        for(int i = 0; i < n ; i++)
            clouds[i] = in.nextInt();
        
        int currentLocation = k % n;
        int energy;
        energy = (clouds[k % n] == 1) ?  97 : 99;

        // initialized to after the first step
        
        while(currentLocation != 0) {
            energy -= (clouds[(currentLocation + k) % n] == 1) ? 3 : 1;
            
            currentLocation = (currentLocation + k) % n;
        }  
        System.out.println(energy);
    }
}