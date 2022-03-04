/* https://leetcode.com/problems/climbing-stairs

You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.
*/

public class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1; //1 way to reach stair 0
        memo[1] = 1; //1 way to reach stair 1
        
        for(int i = 2 ; i < n + 1 ; i++) {
            memo[i] = memo[i - 2] + memo[i - 1];
        }
        return memo[n];                               
    }
}
