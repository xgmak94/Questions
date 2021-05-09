// https://www.hackerrank.com/challenges/utopian-tree
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for(int i = 0 ; i < t ; i++) {
            int height = 1;
            int cycles = scan.nextInt();
            for(int j = 1 ; j <= cycles ; j++) {
                if(j % 2 == 0)
                    height += 1;
                else
                    height = height << 1; //shift left 1 is same as doubling
            }
            System.out.println(height);
        }
    }
}