/*
PALINDROME PERMUTATION
Given a string, write a function to check if it is a permutation of a palindrome. 
A palindrome is a word or phrase that is the same forwards and backwards. 
A permutation is a rearrangement of letters. 
The palindrome does not need to be limited to just dictionary words.

Example
Input: Tact Coa
Output: True (permutations: "taco cat", "atco cta", etc)
*/

import java.io.*;
import java.util.*;

public class Solution {
	static boolean isPermutationOfPalindrome(String s) {
		int[] alphabetCount = new int[26];
		
		char[] letters = s.toCharArray();
		int totalLength = letters.length;
		for(int i = 0 ; i < totalLength ; i++)
			alphabetCount[letters[i] - 'a']++;

		//if the totallength is even every letter must appear 2n amount of times
		//if the totallength is odd ever letter must appear 2n amount of times except for 1 that appears 2n + 1 times

		//NOTE: Could have also checked if any 2 letters had 2n + 1 frequencies as that is impossible with a palindrome

		if(totalLength % 2 == 0) {
			for(int i = 0 ; i < 26 ; i++) {
				if(alphabetCount[i] % 2 == 1)
					return false;
			}
		}
		else if(totalLength % 2 == 1) {
			boolean oddCounted = false;
			for(int i = 0 ; i < 26 ; i++) {
				if(alphabetCount[i] % 2 == 1) {
					if(oddCounted == false)  {
						oddCounted = true;
					}
					else {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String pali = "Ratzs live on no evil starz";
		System.out.println(isPermutationOfPalindrome(pali));
		String pali2 = "Zeus was deified, saw Suez";
		System.out.println(isPermutationOfPalindrome(pali2));
	}
}