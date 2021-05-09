/* https://leetcode.com/problems/island-perimeter

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. 
Grid cells are connected horizontallyvertically (not diagonally). 
The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). 
The island doesn't have lakes (water inside that isn't connected to the water around the island). 
One cell is a square with side length 1. 
The grid is rectangular, width and height don't exceed 100. 
Determine the perimeter of the island.
*/

class Solution {
    public int islandPerimeter(int[][] grid) {
        int p = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(grid[i][j] == 1) {
                    if(i == 0 || grid[i-1][j] == 0) {// top
                        p++;
                    }
                    if(i == n-1 || grid[i+1][j] == 0) {//bot
                        p++;
                    }
                    if(j == 0 || grid[i][j-1] == 0) {//left
                        p++;
                    }
                    if(j == m-1 || grid[i][j+1] == 0) {//right
                        p++;
                    }
                }
            }
        }
        return p;
    }
}
