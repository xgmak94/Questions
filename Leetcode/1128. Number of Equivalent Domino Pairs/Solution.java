/* https://leetcode.com/problems/number-of-equivalent-domino-pairs/

Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

Example 1:
Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
*/

class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int numEqual = 0;
        
        for(int[] d : dominoes) {
            int k = Math.min(d[0], d[1]) * 100 + Math.max(d[0], d[1]); //separate all of the pairs into buckets
            
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        
        for (int v : map.values()) {
            numEqual += v * (v - 1) / 2; //n choose 2 is num of equivalences
        }
        return numEqual;
    }
}