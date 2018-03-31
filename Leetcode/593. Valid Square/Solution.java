/* https://leetcode.com/problems/valid-square/discuss/

Given the coordinates of four points in 2D space, return whether the four points could construct a square.

The coordinate (x,y) of a point is represented by an integer array with two integers.

Example:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: True

*/

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        
        set.add(dist(p1,p2));
        set.add(dist(p1,p3));
        set.add(dist(p1,p4));
        set.add(dist(p2,p3));
        set.add(dist(p2,p4));
        set.add(dist(p3,p4));
        
        return !set.contains(0) && set.size() == 2; //distance cannot be 0 or else 2 of the points are equal, should only be 2 distances if there is a square, edge + diagonal
    }
    
    public int dist(int[] p1, int[] p2) {
        int y = p2[1] - p1[1];
        int x = p2[0] - p1[0];
        
        return x*x + y*y;
    }
}
