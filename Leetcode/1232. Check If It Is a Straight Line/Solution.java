/* https://leetcode.com/problems/check-if-it-is-a-straight-line/

You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.

Example 1:
Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true

Example 2:
Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false
*/

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length < 2) return false;
        
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
               
        for(int i = 2 ; i < n ; i++) {
            int x3 = coordinates[i][0];
            int y3 = coordinates[i][1];

            //  (y2-y1)       (y3-y1)
            //  -------  ==   ------
            //  (x2-x1)       (x3-x1)
            if(((y2-y1)*(x3-x1)) != ((y3-y1)*(x2-x1))) { //slope is same from point pt (x0,y0) to (xi,yi) AND (x1,y1) to (xi,yi)
               return false;
            }
        }
        return true;
    }
}
