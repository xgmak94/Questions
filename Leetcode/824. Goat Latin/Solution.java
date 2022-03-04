/* https://leetcode.com/problems/goat-latin/

A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.

We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)

The rules of Goat Latin are as follows:

If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
For example, the word 'apple' becomes 'applema'.
 
If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
For example, the word "goat" becomes "oatgma".
 
Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
Return the final sentence representing the conversion from S to Goat Latin. 
*/

class Solution {
    public String toGoatLatin(String S) {
        char[] v = new char[]{'a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'};
        Set<Character> vowels = new HashSet<>();
        for(char vowel : v) {
            vowels.add(vowel);
        }
        
        StringBuilder sb = new StringBuilder();
        int numWord = 1;
        
        for(String word : S.split(" ")) {
            char c = word.charAt(0);
            if(vowels.contains(c)) { //append whole word
                sb.append(word);
            }
            else {
                sb.append(word.substring(1)); //append all but first letter
                sb.append(word.substring(0, 1)); //append first letter at end
            }
            sb.append("ma");
            
            for(int i = 0 ; i < numWord ; i++) { 
                sb.append("a");
            }
            sb.append(" ");
            numWord++;
        }
        return sb.toString().trim();
    }
}
