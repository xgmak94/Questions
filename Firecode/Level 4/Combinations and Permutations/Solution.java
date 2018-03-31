/*
Given a string, list all possible combinations and permutations of its characters.

Examples:
getCombPerms("a") ==> {"a"}

getCombPerms("ab") ==> {"a","ab","ba","b"}
*/

public static ArrayList<String> getCombPerms(String s) {
    ArrayList<String> permutations = new ArrayList<String>(); 
    if (s == null)  return null;    // error case
    else if (s.length() == 1) {     // base case
        permutations.add(s); 
        return permutations; 
    }
    String first = s.substring(0,1);    // get and add the first character
    permutations.add(first);
    String remainder = s.substring(1);  // remove the first character
    ArrayList<String> words = getCombPerms(remainder);
    // Insert the first character into each possible position in permutation
    for (String word : words) 
        for (int j = 0; j <= word.length(); j++) 
            permutations.add(insertCharAt(word, first, j)); 
        permutations.addAll(words);     // add permutations without the first character
    return permutations; 
  }
public static String insertCharAt(String word, String c, int i) {
    String start = word.substring(0, i);
    String end = word.substring(i);
    return start + c + end;
}




public static ArrayList<String> getCombPerms(String s) {
    if (s == null) {
        return null;
    }
    
    ArrayList<String> combPerms = new ArrayList<>();
    getCombPerms("", s, combPerms);
    return combPerms;
}

private static void getCombPerms(String prefix, String s, List<String> combPerms) {
    if (!prefix.isEmpty()) {
        combPerms.add(prefix);
    }

    for (int i = 0; i < s.length(); i++) {
        getCombPerms(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1), combPerms);
    }
}