/*
ONE AWAY
There are three types of edits that can be performed on strings
	1. Insert a character
	2. Remove a character
	3. Replace a character
Given two strings, write a function to check if they are one edit (or zero edits) away.

Example

pale 	ple 	-> true
pales 	pale 	-> true
pale 	bale 	-> true
pale 	bake 	-> false
*/

import java.io.*;
import java.util.*;

public class Solution {
	static boolean oneEditAway(String firstWord, String secondWord) {
		int lengthDifference = firstWord.length() - secondWord.length();

		if(lengthDifference == 0) { // if difference is 0 must be replacing a character
			return oneEditReplace(firstWord, secondWord);
		}
		else if(lengthDifference == 1) {
			return oneEditInsert(firstWord, secondWord); // secondword needs something to be inserted
		}
		else if(lengthDifference == -1) {
			return oneEditInsert(secondWord, firstWord); // firstword needs something to be inserted
		}

		return false; // if difference isnt -1, 0, 1 then too many edits apart
	}

	static boolean oneEditReplace(String firstWord, String secondWord) {
		boolean foundDifference = false;
		for(int i = 0 ; i < firstWord.length() ; i++) {
			if(firstWord.charAt(i) != secondWord.charAt(i)) {
				if(foundDifference == false) {
					foundDifference = true;
				}
				else if(foundDifference = true) {
					return false;
				}
			}
		}
		return true;
	}

	static boolean oneEditInsert(String firstWord, String secondWord) {
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String firstWord = scan.nextLine();
		String secondWord = scan.nextLine();

		boolean oneEdit = oneEditAway(firstWord, secondWord);
		System.out.println(oneEdit);

	}
}