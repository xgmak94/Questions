/*
Implement a method that checks if two strings are permutations of each other. 


permutation("CAT","ACT") --> true

permutation("hello","aloha") --> false
*/

public static boolean permutation(String str1, String str2) {
    char[] chars1 = str1.toCharArray();
    char[] chars2 = str2.toCharArray();
    
    Arrays.sort(chars1);
    Arrays.sort(chars2);
    
    String sorted1 = new String(chars1);
    String sorted2 = new String(chars2);
    
    return sorted1.equals(sorted2);
}