/* https://leetcode.com/problems/climbing-stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
*/

public class Solution {
    public int climbStairs(int n) {
        if(n < 3)
            return n;
        
        int[] memo = new int[n + 1];
        memo[1] = 1;
        memo[2] = 2;
        
        for(int i = 3 ; i < n + 1 ; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        return memo[n];                               
    }
}
