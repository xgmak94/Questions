/*
Given a String, write a method - longestPalSubstr that finds and returns the longest substring which is also a Palindrome. Try and accomplish this in at most O(n2) runtime. 

Examples : 
"bccb" => "bccb"
"bccd" => "cc"
"bccc" => "ccc"

*/

public String longestPalSubstr(String str){
    
    if(str == null || str.length() < 2) return str;
    
    int len = str.length();
    
    // memo[start][finish] is true if the String is a palindrome
    // between .charAt(start) and .charAt(finish)
    boolean[][] memo = new boolean[len][len];
    int maxSubstrLen = 1;
    int maxSubstrStartIndex = 0;
    
    // Mark all length 1 substrings as palindromes.
    for(int i = 0; i < len; i++){
        memo[i][i] = true;
    }
    
    // Selectively mark all length 2 substrings as palindromes
    // in a single pass.
    for(int i = 0; i < len-1; i++){
        if(str.charAt(i) == str.charAt(i+1)){
            memo[i][i+1] = true;
            maxSubstrLen = 2;
            maxSubstrStartIndex = i;
        }
    }
    
    // Scan for substrings of length > 2 and length < len. Remember that 
    // memo[l][] represents the starting
    // character str.charAt(l) and memo[][l] represents the ending character
    // in our check.
    for(int l = 3; l <= len; l++){
        // Run the check until you reach the end of the String. i is the 
        // start index.
        for(int i = 0; i + l-1 < len; i++ ){
            // j is the end index.
            int j = i + l-1;
            
            // In a String "abba", if we're at the second "b" -> "abb",
            // "abba" is a palindrome only if "bb" were a palindrome and "a" == "a"
            // at the opposite ends of the String. Can be translated to the following
            // condition using the memo pad:
            if(memo[i+1][j-1] && str.charAt(i) == str.charAt(j)){
                memo[i][j] = true;
                maxSubstrLen = l;
                maxSubstrStartIndex = i;
            }
        }
    }
    return str.substring(maxSubstrStartIndex, maxSubstrStartIndex + maxSubstrLen);
}