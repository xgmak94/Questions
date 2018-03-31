/*
Find the first non-duplicate character in a string. Return null if no unique character is found. 

firstNonRepeatedCharacter( "abcdcd" ) --> 'a'

firstNonRepeatedCharacter( "cbcd" ) --> 'b'

firstNonRepeatedCharacter( "cdcd" ) --> null
*/

public static Character firstNonRepeatedCharacter(String str) {
  HashMap<Character, Integer> characterhashtable = new HashMap<Character, Integer>();
  int i, length;
  Character c;
  length = str.length(); // Scan string and build hash table
  for (i = 0; i < length; i++) {
      c = str.charAt(i);
      if (characterhashtable.containsKey(c)) {
          // Increment count corresponding to c
          characterhashtable.put(c, characterhashtable.get(c) + 1);
      } else {
          characterhashtable.put(c, 1);
      }
  }
  // Search character hashtable in order of string str
  for (i = 0; i < length; i++) {
      c = str.charAt(i);
      if (characterhashtable.get(c) == 1)
          return c;
  }
  return null;
}