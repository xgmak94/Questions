/* https://leetcode.com/problems/find-the-town-judge/

In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.

If the town judge exists, then:
The town judge trusts nobody.
Everybody (except for the town judge) trusts the town judge.
There is exactly one person that satisfies properties 1 and 2.
You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi.

Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.

Example 1:
Input: n = 2, trust = [[1,2]]
Output: 2

Example 2:
Input: n = 3, trust = [[1,3],[2,3]]
Output: 3

Example 3:
Input: n = 3, trust = [[1,3],[2,3],[3,1]]
Output: -1
 
Constraints:
1 <= n <= 1000
0 <= trust.length <= 104
trust[i].length == 2
All the pairs of trust are unique.
ai != bi
1 <= ai, bi <= n
*/

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trusts = new int[n+1]; //n people indexed from 1 to n
        
        for(int[] pair : trust) {
            int trustee = pair[0];
            int trusted = pair[1];
            trusts[trustee]--; //trusts someone
            trusts[trusted]++; //trusted by someone
        }
        
        for(int i = 1 ; i <= n ; i++) {
            if(trusts[i] == n-1) { //trusted by all other n-1 people, trusts nobody
                return i;
            }
        }
        return -1; //does not exist
    }
}
