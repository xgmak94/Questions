/* https://leetcode.com/problems/triangle/

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10

Constraints:
1 <= triangle.length <= 200
triangle[0].length == 1
triangle[i].length == triangle[i - 1].length + 1
-104 <= triangle[i][j] <= 104

Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        for(int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        
        for(int i = 1 ; i < triangle.size() ; i++) {
            for(int j = 0 ; j < triangle.get(i).size() ; j++) {
                dp[i][j] = Math.min(dp[i-1][Math.max(0, j-1)], dp[i-1][Math.min(triangle.get(i).size(), j)]) + triangle.get(i).get(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0 ; j < triangle.size() ; j++) {
            min = Math.min(dp[triangle.size() - 1][j], min);
        }
        return min;
    }
}
