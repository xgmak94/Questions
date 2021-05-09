/*

Given a String input, find the length of the longest substring that is made up of non-repeating characters. For ex, the longest substrings without repeated characters in “BCEFGHBCFG” are “CEFGHB” and “EFGHBC”, with length = 6. In the case of "FFFFF", the longest substring is "F" with a length of 1.
Example:

Input : aaabbbabcde 
Output: 5

*/

public static int longestNRSubstringLen(String input) {
    if (input.length() == 0)
        return 0;
        
    HashMap<Character, Integer> map = new HashMap<>();
    
    int maxLength = Integer.MIN_VALUE;
    for(int start = 0, end = 0 ; end < input.length() ; end++) {
        char c = input.charAt(end);
        if(map.containsKey(c)) {
            start = Math.max(start, map.get(input.charAt(end)) + 1);
        }
        map.put(c, end);
        
        int currLength = end - start + 1;
        maxLength = Math.max(maxLength, currLength);
    }
    return maxLength;
}