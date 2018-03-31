// https://www.hackerrank.com/challenges/taum-and-bday

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static long totalCost(long numBlack, long numWhite, long costBlack, long costWhite, long costSwap) {
            long newBlack = costWhite + costSwap;
            long newWhite = costBlack + costSwap;
            costBlack = (newBlack < costBlack) ? newBlack : costBlack;
            costWhite = (newWhite < costWhite) ? newWhite : costWhite;

            return ((numBlack*costBlack) + (numWhite*costWhite));
	}
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            long numBlack = in.nextLong();
            long numWhite = in.nextLong();
            long costBlack = in.nextLong();
            long costWhite = in.nextLong();
            long costSwap = in.nextLong();

            long minCost = totalCost(numBlack, numWhite, costBlack, costWhite, costSwap);
            System.out.println(minCost);
        }
    }
}