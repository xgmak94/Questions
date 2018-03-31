/*
Compress a sorted String by replacing instances of repeated characters with the character followed by the count of the character.

compressString("aaabbbbbcccc") --> a3b5c4
compressString("aabbbbccc") --> a2b4c3
compressString("abc") --> abc

Note: This kind of compression will only be effective when the count of consecutive identical characters is greater than 1.

*/

public static String compressString(String s) {
    StringBuilder compressed = new StringBuilder();
	int compressedLength = 0;
	for(int i = 0 ; i < s.length() ; i++) {
		compressedLength++;		
		if( i == s.length() - 1 || s.charAt(i) != s.charAt(i + 1)) {
			compressed.append(s.charAt(i));
			if(compressedLength > 1) {
			    compressed.append(compressedLength);
			}
			compressedLength = 0;
		}
	}
	return compressed.toString();
}