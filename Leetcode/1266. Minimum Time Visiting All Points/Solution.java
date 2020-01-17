/* https://leetcode.com/problems/minimum-time-visiting-all-points/
On a plane there are n points with integer coordinates points[i] = [xi, yi]. Your task is to find the minimum time in seconds to visit all points.

You can move according to the next rules:

In one second always you can either move vertically, horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
You have to visit the points in the same order as they appear in the array.

*/

class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int dist = 0;
        int[] prev = points[0];
        for(int i = 1 ; i < points.length ; i++) {
            int[] curr = points[i];
            
            int[] delta = new int[2];
            delta[0] = Math.abs(prev[0] - curr[0]);
            delta[1] = Math.abs(prev[1] - curr[1]);
            
            dist += (Math.min(delta[0], delta[1]) + Math.abs(delta[0]-delta[1]));
            
            prev[0] = curr[0];
            prev[1] = curr[1];
        }
        return dist;
    }
}