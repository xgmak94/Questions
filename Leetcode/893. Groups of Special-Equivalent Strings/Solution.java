/* https://leetcode.com/problems/groups-of-special-equivalent-strings/

You are given an array A of strings.

A move onto S consists of swapping any two even indexed characters of S, or any two odd indexed characters of S.

Two strings S and T are special-equivalent if after any number of moves onto S, S == T.

For example, S = "zzxy" and T = "xyzz" are special-equivalent because we may make the moves "zzxy" -> "xzzy" -> "xyzz" that swap S[0] and S[2], then S[1] and S[3].

Now, a group of special-equivalent strings from A is a non-empty subset of A such that:

Every pair of strings in the group are special equivalent, and;
The group is the largest size possible (ie., there isn't a string S not in the group such that S is special equivalent to every string in the group)
Return the number of groups of special-equivalent strings from A.

Example 1:
Input: ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
Output: 3
Explanation: 
One group is ["abcd", "cdab", "cbad"], since they are all pairwise special equivalent, and none of the other strings are all pairwise special equivalent to these.

The other two groups are ["xyzz", "zzxy"] and ["zzyx"].  Note that in particular, "zzxy" is not special equivalent to "zzyx".

Example 2:
Input: ["abc","acb","bac","bca","cab","cba"]
Output: 3

Note:
1 <= A.length <= 1000
1 <= A[i].length <= 20
All A[i] have the same length.
All A[i] consist of only lowercase letters.
*/

class Solution {
    public int numSpecialEquivGroups(String[] A) {
        Set<String> set = new HashSet<>(); //use a set to differentiate the different sigs we generate
        for(String s : A) {
            set.add(generate(s));
        }
        return set.size();
    }
    
    public String generate(String s) { //generate a sig to differetiate
        int[] odd = new int[26]; //separate even and odd
        int[] even = new int[26];
        for(int i = 0 ; i < s.length() ; i++) {
            char c = s.charAt(i);
            if(i % 2 == 0) even[c-'a']++;
            else odd[c-'a']++;
        }
        
        StringBuilder sig = new StringBuilder();
        for(int i = 0 ; i < 26 ; i++) {
            sig.append(odd[i] + (char)(i+'a'));
            sig.append(even[i] + (char)(i+'a'));
        }
        return sig.toString();
    }
}
