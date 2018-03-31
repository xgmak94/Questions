/* https://leetcode.com/problems/maximum-length-of-pair-chain/description/

You are given n pairs of numbers. In every pair, the first number is always smaller than the second number.

Now, we define a pair (c, d) can follow another pair (a, b) if and only if b < c. Chain of pairs can be formed in this fashion.

Given a set of pairs, find the length longest chain which can be formed. You needn't use up all the given pairs. You can select pairs in any order.

Example 1:
Input: [[1,2], [2,3], [3,4]]
Output: 2
Explanation: The longest chain is [1,2] -> [3,4]

*/

class Solution {
    public int findLongestChain(int[][] pairs) {
        if(pairs == null || pairs.length == 0)
            return 0;
        
        Arrays.sort(pairs, (a,b) -> (a[0] - b[0]));
        int[] memo = new int[pairs.length];
        Arrays.fill(memo, 1);
        
        int maxLength = 1;
        
        for(int i = 1 ; i < pairs.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(pairs[j][1] < pairs[i][0]) {
                    memo[i] = Math.max(memo[j] + 1, memo[i]);
                }         
                maxLength = Math.max(memo[i], maxLength);
                }
            }
        }
        return maxLength;
    }
}
