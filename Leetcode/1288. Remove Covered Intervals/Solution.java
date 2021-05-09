/* https://leetcode.com/problems/remove-covered-intervals/

Given a list of intervals, remove all intervals that are covered by another interval in the list. 
Interval [a,b) is covered by interval [c,d) if and only if c <= a and b <= d.

After doing so, return the number of remaining intervals.

Example 1:
Input: intervals = [[1,4],[3,6],[2,8]]
Output: 2
Explanation: Interval [3,6] is covered by [2,8], therefore it is removed.
*/

class Solution {
    public int removeCoveredIntervals(int[][] A) {
        int res = 0;
        int left = -1;
        int right = -1;
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        for (int[] v : A) {
            if (v[0] > left && v[1] > right) { //this is a new interval not covered
                left = v[0];
                res++;
            }
            right = Math.max(right, v[1]); //extend right side of interval
        }
        return res;
    }
}
