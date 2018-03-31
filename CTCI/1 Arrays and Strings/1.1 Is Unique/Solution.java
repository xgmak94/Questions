/*
IS UNIQUE
Implement an algorithm to determine if a string has all unique characters.
What if you cannot use additional data structures?
*/

import java.io.*;
import java.util.*;

public class Solution {
    static boolean isUniqueChars(String s) {
        char[] letters = s.toCharArray();

        Arrays.sort(letters);

        for(int i = 0 ; i < letters.length - 1 ; i ++) {
            if(letters[i] == letters[i + 1]) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}