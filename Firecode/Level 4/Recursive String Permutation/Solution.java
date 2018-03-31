/*

String permutations are the various possible strings made by the rearrangement of the characters in the original String.

For example, the permutations of car are

car, cra, acr, arc, rac, rca
Write a recursive method getPermutations() that returns all permutations of an input String in an ArrayList. Define a helper method if needed. For the sake of simplicity, assume that all characters in the input String are unique.

Examples:

getPermutations("") -> ArrayList -> []

getPermutations("c") -> ArrayList -> ["c"]

getPermutations("cat") -> ArrayList -> ["cat","cta","act","atc","tca","tac"]*

*Order does not matter.

*/

public static ArrayList<String> getPermutations(String s) {
        ArrayList<String> permutations = new ArrayList<String>(); 
        if (s == null) // error case
            return null;
        else if (s.length() == 0) { // base case
            permutations.add(""); 
            return permutations; 
        }
        char first = s.charAt(0); // get the first character
        String remainder = s.substring(1); // remove the first character 
        ArrayList<String> words = getPermutations(remainder);
        for (String word : words) {
            for (int j = 0; j <= word.length(); j++) {
                permutations.add(insertCharAt(word, first, j)); 
            }
        }
        return permutations; 
    }
    // Helper method
    public static String insertCharAt(String word, char c, int i) {
        String start = word.substring(0, i);
        String end = word.substring(i);
        return start + c + end;
    }