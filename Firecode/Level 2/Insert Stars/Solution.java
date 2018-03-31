/*

Given a string, recursively compute a new string where the identical adjacent characters in the original string are separated by a "*".

Examples:
insertPairStar("cac") ==> "cac"

insertPairStar("cc") ==> "c*c"
*/

public static String insertPairStar(String s) {
    // Error case
    if (s == null)
      return null;
    // Base case
    else if (s.length() == 1)
      return s;
    // Recursive case for matching
    else if (s.substring(0,1).equals(s.substring(1,2))) {
      return s.substring(0,1) + "*" + insertPairStar(s.substring(1,s.length()));
    }
    // Recursive case for non-matching
    return s.substring(0,1) + insertPairStar(s.substring(1,s.length()));
  }