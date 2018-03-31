/*
URLify
Write a method to replace all spaces in a string with '%20'.
You may assume that the string ha sufficient space at the end to hold the additional characters, and that you are given the "true" length of the string.
(Note: If implementing in java please use a character array so that you can perform this operation in place.)

Example
Input: "Mr John Smith"
Output: "Mr%20John%20Smith"

*/

import java.io.*;
import java.util.*;

public class Solution {
	static String URLify(char[] letters) {
		StringBuilder s = new StringBuilder();
		for(int i = 0 ; i < letters.length ; i++) {
			if(letters[i] == ' ')
				s.append("%20");
			else
				s.append(letters[i]);
		}
		return s.toString();
	}

	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		char[] letters = s.toCharArray();

		String replaced = URLify(letters);
		System.out.println(replaced);
	}
}