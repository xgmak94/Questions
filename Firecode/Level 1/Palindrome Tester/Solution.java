/*

A palindrome is a string or sequence of characters that reads the same backward as forward. For example, "madam" is a palindrome. Write a method that takes in a String and returns a boolean -> true if the input String is a palindrome and false if it is not. An empty string and a null input are considered palindromes. You also need to account for the space character. For example, "race car" should return false as read backward it is "rac ecar".
Examples:
isStringPalindrome("madam") -> true
isStringPalindrome("aabb") -> false
isStringPalindrome("race car") -> false
isStringPalindrome("") -> true
isStringPalindrome(null) -> true

*/

public static boolean isStringPalindrome(String str){
    if(str == null || str.length() < 2)
        return true;
    
    for(int i = 0 ; i < str.length() / 2 ; i++) {
        if(str.charAt(i) != str.charAt(str.length() - i - 1))
            return false;
    }
    return true;
}