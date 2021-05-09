/* https://leetcode.com/problems/spiral-matrix-iii/

On a 2 dimensional grid with R rows and C columns, we start at (r0, c0) facing east.

Here, the north-west corner of the grid is at the first row and column, and the south-east corner of the grid is at the last row and column.

Now, we walk in a clockwise spiral shape to visit every position in this grid. 

Whenever we would move outside the boundary of the grid, we continue our walk outside the grid (but may return to the grid boundary later.) 

Eventually, we reach all R * C spaces of the grid.

Return a list of coordinates representing the positions of the grid in the order they were visited.

Example 1:
Input: R = 1, C = 4, r0 = 0, c0 = 0
Output: [[0,0],[0,1],[0,2],[0,3]]

Example 2:
Input: R = 5, C = 6, r0 = 1, c0 = 4
Output: [[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]

Note:
1 <= R <= 100
1 <= C <= 100
0 <= r0 < R
0 <= c0 < C
*/

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
    	int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int numSteps = 0;
        int dir = 0;
        int idx = 0;
        int[][] ret = new int[R*C][2];
        ret[idx++] = new int[]{r0, c0};
        
        while(idx < R*C) {
            if(dir % 2 == 0) numSteps++; //increase steps every 2 dir changes
            for(int i = 0 ; i < numSteps ; i++) {
                r0 += dirs[dir % 4][0];
                c0 += dirs[dir % 4][1];
                if(checkValid(R, C, r0, c0)) ret[idx++] = new int[]{r0, c0};
            }
            dir++;
        }
        return ret;
    }
    public boolean checkValid(int R, int C, int currR, int currC) {
        if(currR < R && currR >= 0 && currC < C && currC >= 0) return true;
        return false;
    }
}

class Solution {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        List<Integer[]> list = new ArrayList<>();
        int currR = r0;
        int currC = c0;
        int numSteps = 1;
        list.add(new Integer[]{currR, currC});
        while(list.size() < R*C) {
            for(int i = 0 ; i < numSteps ; i++) { //right
                currC++;
                if(checkValid(R, C, currR, currC)) 
                    list.add(new Integer[]{currR, currC});
            }
            for(int i = 0 ; i < numSteps ; i++) { //down
                currR++;
                if(checkValid(R, C, currR, currC)) 
                    list.add(new Integer[]{currR, currC});
            }
            numSteps++;
            for(int i = 0 ; i < numSteps ; i++) { //left
                currC--;
                if(checkValid(R, C, currR, currC)) 
                    list.add(new Integer[]{currR, currC});
            }
            for(int i = 0 ; i < numSteps ; i++) { //up
                currR--;
                if(checkValid(R, C, currR, currC)) 
                    list.add(new Integer[]{currR, currC});
            }
            numSteps++;
        }
        
        int[][] ret = new int[R*C][2];
        for(int i = 0 ; i < R*C ; i++) {
            Integer[] coord = list.get(i);
            ret[i][0] = coord[0];
            ret[i][1] = coord[1];
        }
        return ret;
    }
    
    public boolean checkValid(int R, int C, int currR, int currC) {
        if(currR < R && currR >= 0 && currC < C && currC >= 0) {
            return true;
        }
        return false;
    }
}
