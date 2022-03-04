/* https://leetcode.com/problems/find-common-characters/

Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).
For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

Example 1:
Input: ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: ["cool","lock","cook"]
Output: ["c","o"]
*/
import java.util.*;
class Solution {
    public static List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        
        int[] commonDict = new int[26];
        Arrays.fill(commonDict, Integer.MAX_VALUE);
        
        for(String word : A) {
            int[] currDict = makeDict(word);
            for(int j = 0 ; j < 26 ; j++) {
                commonDict[j] = Math.min(currDict[j], commonDict[j]);
            }
        }
        
        for(int i = 0 ; i < 26 ; i++) {
            int freq = commonDict[i];
            while(freq > 0) {
                list.add((char)(i+'a') + "");
                freq--;
            }
        }
        return list;
    }
    public static int[] makeDict(String s) {
        int[] dict = new int[26];
        for(char c : s.toCharArray()) {
            dict[c-'a']++;
        }
        return dict;
    }
    public static void main(String[] args) {
        List<String> ex1 = commonChars(new String[]{"bella", "label", "roller"});
        List<String> ex2 = commonChars(new String[]{"cool", "lock", "cook"});

        for(String word : ex1) {
            System.out.printf("%s ", word);
        }
        System.out.println();

        for(String word : ex2) {
            System.out.printf("%s ", word);
        }
        System.out.println();
    }
}
