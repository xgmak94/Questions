/* https://leetcode.com/problems/detect-capital

Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
*/

public class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.length() < 2)
            return true;
        
        int length = word.length();
        char c = word.charAt(0);
        
        if(Character.isUpperCase(c) == true) {
            if(Character.isUpperCase(word.charAt(1)) == true) {
                for(int i = 2 ; i < length ; i++)
                    if(Character.isUpperCase(word.charAt(i)) == false)
                        return false;
            }
            else {
                for(int i = 2 ; i < length ; i++)
                    if(Character.isUpperCase(word.charAt(i)) == true)
                        return false;
            }
        }
        else if(Character.isUpperCase(c) == false) {
            for(int i = 1 ; i < length ; i++)
                if(Character.isUpperCase(word.charAt(i)) == true)
                    return false;
        }
        return true;
    }
}
