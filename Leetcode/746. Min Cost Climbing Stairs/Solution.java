/* https://leetcode.com/problems/min-cost-climbing-stairs/

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps.
You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.

Constraints:
2 <= cost.length <= 1000
0 <= cost[i] <= 999
*/

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length <= 1) return 0;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0; //we can start at step 0
        dp[1] = 0; //we can start at step 1
        
        for(int i = 2 ; i <= cost.length ; i++) {
            dp[i] = Math.min(dp[i-2] + cost[i-2], //cost to go 2 steps from i-2 step
            				dp[i-1] + cost[i-1]); //cost to go 1 step from i-1 step
        }
        return dp[cost.length];
    }
}
