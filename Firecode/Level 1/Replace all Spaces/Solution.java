/*

Write a method to replace all spaces in a string with a given replacement string. 

replace("This is a test","/") --> "This/is/a/test"

Note: Avoid using the in-built String.replaceAll() method. 

*/

public static String replace(String a, String b) {
    StringBuilder replaced = new StringBuilder();
    
    for(int i = 0 ; i < a.length() ; i++) {
        if(a.charAt(i) == ' ') {
            replaced.append(b);
        }
        else {
            replaced.append(a.charAt(i));
        }
    }
    return replaced.toString();
}