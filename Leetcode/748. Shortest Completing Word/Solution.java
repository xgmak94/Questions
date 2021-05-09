/* https://leetcode.com/problems/shortest-completing-word/

Find the minimum length word from a given dictionary words, which has all the letters from the string licensePlate.
Such a word is said to complete the given string licensePlate

Here, for letters we ignore case. For example, "P" on the licensePlate still matches "p" on the word.

It is guaranteed an answer exists. If there are multiple answers, return the one that occurs first in the array.

The license plate might have the same letter occurring multiple times. For example, given a licensePlate of "PP", the word "pair" does not complete the licensePlate, but the word "supper" does.

Example 1:
Input: licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
Output: "steps"
Explanation: The smallest length word that contains the letters "S", "P", "S", and "T".
Note that the answer is not "step", because the letter "s" must occur in the word twice.
Also note that we ignored case for the purposes of comparing whether a letter exists in the word.

Example 2:
Input: licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
Output: "pest"
Explanation: There are 3 smallest length words that contains the letters "s".
We return the one that occurred first.
*/

class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int shortestLength = Integer.MAX_VALUE;
        String shortestWord = null;

        int[] chars = new int[26];
        Arrays.fill(chars, 0);
        
        for(char c : licensePlate.toLowerCase().toCharArray()) { //get the count of all letters in license plate
            if(Character.isLetter(c)) {
                chars[c-'a']++;
            }
        }
        
        for(String word : words) {
            int[] plateCount = chars.clone();
            
            if(word.length() < shortestLength && canMake(plateCount, word)) {
                shortestLength = word.length();
                shortestWord = word;
            }
        }
        return shortestWord;
    }
    
    public boolean canMake(int[] plateCount, String word) {
        for(char c : word.toCharArray()) {
            plateCount[c-'a']--;
        }
        
        for(int i = 0 ; i < 26 ; i++) { //if theres any letter missing we cannot make it
            if(plateCount[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
