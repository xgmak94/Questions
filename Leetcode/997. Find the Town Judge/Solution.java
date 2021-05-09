/* https://leetcode.com/problems/find-the-town-judge/

In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:
The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

Example 1:
Input: N = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: N = 3, trust = [[1,3],[2,3]]
Output: 3
Example 3:
Input: N = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1

Example 4:
Input: N = 3, trust = [[1,2],[2,3]]
Output: -1

Example 5:
Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
Output: 3
*/

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trusts = new int[N+1]; //n people indexed from 1 to n
        
        for(int[] pair : trust) {
            trusts[pair[0]]--; //trusts someone
            trusts[pair[1]]++; //trusted by someone
        }
        
        for(int i = 1 ; i < N+1 ; i++) {
            if(trusts[i] == N-1) {//trusted by all other N-1 people, trusts nobody
                return i;
            }
        }
        return -1;
    }
}
