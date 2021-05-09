/*

Write a method that takes in a String and returns the reversed version of the String.

Examples:
reverseString("abcde") -> "edcba"
reverseString("1") -> "1"
reverseString("") -> ""
reverse("madam") -> "madam"
reverse(null) -> null

*/

public static String reverseString(String str){
    String inputString = str;
    if(str == null || str.length() < 2) {
        return str;
    }
    
    String reversed = new StringBuilder(inputString).reverse().toString();
    
    return reversed;
}