/* https://leetcode.com/problems/partition-labels/

A string S of lowercase letters is given. 
We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0 ; i < S.length() ; i++) {
            last[S.charAt(i) - 'a'] = i; //last index for all 26 characters
        }
        
        List<Integer> ans = new ArrayList();
        int begin = 0, end = 0;
        for (int i = 0 ; i < S.length() ; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']); //get the last occurence of a character in current parition
            if (i == end) {
                ans.add(i - begin + 1); //partition is from begin to i, length i-begin+1
                begin = i + 1; //move begin to after this partition, beginning of next partition
            }
        }
        return ans;
    }
}
