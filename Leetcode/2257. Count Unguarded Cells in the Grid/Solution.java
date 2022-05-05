/* https://leetcode.com/problems/count-unguarded-cells-in-the-grid/

You are given two integers m and n representing a 0-indexed m x n grid. You are also given two 2D integer arrays guards and walls where guards[i] = [rowi, coli] and walls[j] = [rowj, colj] represent the positions of the ith guard and jth wall respectively.

A guard can see every cell in the four cardinal directions (north, east, south, or west) starting from their position unless obstructed by a wall or another guard. A cell is guarded if there is at least one guard that can see it.

Return the number of unoccupied cells that are not guarded.

Example 1:
Input: m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
Output: 7
Explanation: The guarded and unguarded cells are shown in red and green respectively in the above diagram.
There are a total of 7 unguarded cells, so we return 7.

Example 2:
Input: m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
Output: 4
Explanation: The unguarded cells are shown in green in the above diagram.
There are a total of 4 unguarded cells, so we return 4.

Constraints:
1 <= m, n <= 105
2 <= m * n <= 105
1 <= guards.length, walls.length <= 5 * 104
2 <= guards.length + walls.length <= m * n
guards[i].length == walls[j].length == 2
0 <= rowi, rowj < m
0 <= coli, colj < n
All the positions in guards and walls are unique.
*/

class Solution {
    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] arr = new char[m][n];
        for(int[] guard : guards) {
            arr[guard[0]][guard[1]] = 'G';
        }
        
        for(int[] wall : walls) {
            arr[wall[0]][wall[1]] = 'W';
        }
        
        for(int[] guard : guards) {
            dfs(guard, arr, m, n);
        }
        return countUnguarded(arr, m, n);
    }
    public void dfs(int[] guard, char[][] arr, int m, int n) {
        for(int[] dir : dirs) {
            int x = guard[0] + dir[0];
            int y = guard[1] + dir[1];
            while(x >= 0 && y >= 0 && x < m && y < n && arr[x][y] != 'W' && arr[x][y] != 'G') {
                arr[x][y] = 'C'; //can see this cell
                x += dir[0];
                y += dir[1];
            }
        }
    }
    public int countUnguarded(char[][] arr, int m, int n) {
        int count = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(arr[i][j] == Character.MIN_VALUE) { //not written to
                    count++;
                }
            }
        }
        return count;
    }
}
