/*
CHECK PERMUTATION
Given two strings, write a method to decide if one is a permutation of the other
*/

import java.io.*;
import java.util.*;

public class Solution {
	static boolean permutation(String firstWord, String secondWord) {
		char[] firstLetters = firstWord.toCharArray();
		char[] secondLetters = secondWord.toCharArray();

		Arrays.sort(secondLetters);
		Arrays.sort(firstLetters);
		String firstSort = new String(firstLetters);
		String secondSort = new String(secondLetters);

		return firstSort.equals(secondSort);
	}
	public static void main(String[] args) {
		String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}
}