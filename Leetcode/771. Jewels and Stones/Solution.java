/* https://leetcode.com/problems/jewels-and-stones/description/

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
Each character in S is a type of stone you have.
You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: J = "aA", S = "aAAbbbb"
Output: 3

Example 2:
Input: J = "z", S = "ZZ"
Output: 0
*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        
        for(char c : J.toCharArray()) { //add all jewels to set
            set.add(c);
        }

        for(char c : S.toCharArray()) { //if the set of jewels contains this stone ++
            if(set.contains(c)) {
                count++;
            }
        }
        return count;
    }
}
