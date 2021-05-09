/*
Write a method isAnagram that checks if two lowercase input Strings are anagrams of each other. An anagram of a String is a String that is formed by simply re-arranging its letters, using each letter exactly once. Your algorithm should run in linear O(n) time and use constant O(1) space. 

Examples:

isAnagram("abc","cab") => true
isAnagram("b","b") => true
isAnagram("bd","cb") => false
*/

public static boolean isAnagram(String input1, String input2) {
    if(input1 == null || input2 == null || input1.length() != input2.length())
        return false;
        
    char[] chars1 = input1.toCharArray();
    char[] chars2 = input2.toCharArray();
    
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    
    for(int i = 0 ; i < chars1.length ; i++) {
        if(chars1[i] != chars2[i])
            return false;
    }
    return true;
}