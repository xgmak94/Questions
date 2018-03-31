/*
STRING COMPRESSION
Implement a method to perform  basic string compression using the counts of repeated characters.
For example, tehe string aabcccccaaa would become a2b1c5a3.
If the "compressed" string would not become smaller than the original string, your method should return the original string.
You can assume the string only has uppercase and lowercase letters
*/

import java.io.*;
import java.util.*;

public class Solution {
	static String compress(String s) {
		StringBuilder compressed = new StringBuilder();
		int compressedLength = 0;
		for(int i = 0 ; i < s.length() ; i++) {
			compressedLength++;		
			if(i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
				compressed.append(s.charAt(i));
				compressed.append(compressedLength);
				compressedLength = 0;
			}
		}

		return compressed.toString();
	}
	public static void main(String[] args) {
		String str = "aaaaabbbbaaaabbddc";
		System.out.println(str);
		System.out.println(compress(str));
	}
}