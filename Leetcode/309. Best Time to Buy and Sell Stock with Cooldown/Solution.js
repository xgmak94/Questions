/* https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:
Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]

Example 2:
Input: prices = [1]
Output: 0

Constraints:
1 <= prices.length <= 5000
0 <= prices[i] <= 1000
*/

/**
 * @param {number[]} prices
 * @return {number}
 */
var maxProfit = function(prices) {
    dp = {};

    function dfs(i, buying) {
        if(i >= prices.length) return 0;

        if([i, buying] in dp) return dp[[i, buying]];

        if(buying) {
            let buy = dfs(i+1, false) - prices[i]; // next idx selling state
            let cooldown = dfs(i+1, true); //next idx buying state
            dp[[i, buying]] = Math.max(buy, cooldown);
        }
        else {
            let sell = dfs(i+2, true) + prices[i]; // skip idx for cooldown
            let cooldown = dfs(i+1, false); //next idx selling state
            dp[[i, buying]] = Math.max(sell, cooldown);
        }
        return dp[[i, buying]];
    }
    return dfs(0, true);
};
