/* https://leetcode.com/problems/play-with-chips/

There are some chips, and the i-th chip is at position chips[i].

You can perform any of the two following types of moves any number of times (possibly zero) on any chip:
Move the i-th chip by 2 units to the left or to the right with a cost of 0.
Move the i-th chip by 1 unit to the left or to the right with a cost of 1.
There can be two or more chips at the same position initially.

Return the minimum cost needed to move all the chips to the same position (any position).

Example 1:
Input: chips = [1,2,3]
Output: 1
Explanation: Second chip will be moved to positon 3 with cost 1. First chip will be moved to position 3 with cost 0. Total cost is 1.

Example 2:
Input: chips = [2,2,2,3,3]
Output: 2
Explanation: Both fourth and fifth chip will be moved to position two with cost 1. Total minimum cost will be 2.
*/

//move all chips at even indices to position 2, odd indices to position 1, total cost is 0
//move smaller stack over by 1 to create 1 stack, cost is equal to smaller stack
class Solution {
    public int minCostToMoveChips(int[] chips) {
        int even = 0;
        int odd = 0;
        for(int val : chips) {
            if(val % 2 == 0) {
                even++;
            }
            else {
                odd++;
            }
        }
        return Math.min(odd, even);
    }
}
