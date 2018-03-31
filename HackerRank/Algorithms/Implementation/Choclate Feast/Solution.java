// https://www.hackerrank.com/challenges/chocolate-feast
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0 ; i < t ; i++) {
            int dollars = scan.nextInt();
            int cost = scan.nextInt();
            int wrappersTrade = scan.nextInt();
            
            int bought = dollars / cost;
            
            int trade = bought;
            int extra = 0;
            
            // System.out.printf("Bought %d\n", bought);
            // System.out.printf("Have %d wrappers\n", trade);
            while(trade >= wrappersTrade) {
                extra++;
                trade = trade - wrappersTrade + 1; // lose wrappersTrade ammount but gain 1 back from the trade
            }
            System.out.println(bought + extra);
        }
    }
}