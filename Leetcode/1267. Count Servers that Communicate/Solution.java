/* https://leetcode.com/problems/count-servers-that-communicate/

You are given a map of a server center, represented as a m * n integer matrix grid, where 1 means that on that cell there is a server and 0 means that it is no server. Two servers are said to communicate if they are on the same row or on the same column.

Return the number of servers that communicate with any other server.

*/

class Solution {
    public int countServers(int[][] grid) {
        int count = 0;
        
        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0 ; j < grid[0].length ; j++) {
                if(grid[i][j] == 1) {
                    if(canCommunicate(i, j, grid)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    public boolean canCommunicate(int row, int col, int[][] grid) {
        if(checkCol(row, col, grid) || checkRow(row, col, grid))
            return true;
        return false;
    }
    
    public boolean checkCol(int row, int col, int[][] grid) {
        for(int i = 0 ; i < grid.length ; i++) {
            if(grid[i][col] == 1 && row != i)
                return true;
        }
        return false;
    }
    
    public boolean checkRow(int row, int col, int[][] grid) {
        for(int j = 0 ; j < grid[0].length ; j++) {
            if(grid[row][j] == 1 && col != j)
                return true;
        }
        return false;
    }

}

class Solution {
    public int countServers(int[][] grid) {
        int count = 0;
        int numRows = grid.length;
        int numCols = grid[0].length;
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];

        for(int r = 0 ; r < numRows ; r++) {
            for(int c = 0 ; c < numCols ; c++) {
                if(grid[r][c] == 1) {
                    rows[r]++;
                    cols[c]++;
                }
            }
        }

        for(int r = 0 ; r < numRows ; r++) {
        	for(int c = 0 ; c < numCols ; c++) {
        		if(grid[r][c] == 1) {
        			if(rows[r] > 1 || cols[c] > 1) { // not counting itself
        				count++;
        			}
        		}
        	}
        }
        return count;
    }
}
