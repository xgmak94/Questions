/* https://leetcode.com/problems/sort-the-matrix-diagonally/

Given a m * n matrix mat of integers, sort it diagonally in ascending order from the top-left to the bottom-right then return the sorted array.

Example 1:
Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
Output: [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 
Constraints:
m == mat.length
n == mat[i].length
1 <= m, n <= 100
1 <= mat[i][j] <= 100
*/

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        
        for(int i = 0 ; i < r ; i++) {
            List<Integer> list = getDiagElements(mat, i, 0, r, c);
            placeSorted(mat, i, 0, r, c, list);
        }
        
        for(int j = 1 ; j < c ; j++) {
            List<Integer> list = getDiagElements(mat, 0, j, r, c);
            placeSorted(mat, 0, j, r, c, list);
        }
        return mat;
    }
    
    public List<Integer> getDiagElements(int[][] mat, int x, int y, int r, int c) {
        List<Integer> list = new ArrayList<>();
        while(x < r && y < c) {
            list.add(mat[x][y]);
            x++;
            y++;
        }
        Collections.sort(list);
        return list;
    }
    
    public void placeSorted(int[][] mat, int x, int y, int r, int c, List<Integer> list) {
        int idx = 0;
        while(x < r && y < c && idx < list.size()) {
            mat[x][y] = list.get(idx);
            x++;
            y++;
            idx++;
        }
    }
}
