/*

Given an m x n matrix filled with non-negative integers, use depth first search to find the maximum sum along a path from the top-left of the grid to the bottom-right. Return this maximum sum. The direction of movement is limited to right and down.

Example:
Input Matrix : 
             
    1 2 3
    4 5 6
    7 8 9

Output  : 1 + 4 + 7 + 8 + 9 = 29
*/

public static int matrixMaxSumDfs(int[][] grid) {
    return matrixMaxSumDfs(grid, 0, 0);
}

private static int matrixMaxSumDfs(int[][] grid, int row, int col) {
    if(row >= grid.length || col >= grid[0].length)
        return 0;
    return grid[row][col]+Math.max(matrixMaxSumDfs(grid, row+1, col), matrixMaxSumDfs(grid, row, col+1));
}



public static int matrixMaxSumDfs(int[][] grid) {
    class TravelNode {
        int row;
        int col;
        int nodeSum;
        TravelNode(int r, int c, int sum, int[][] grid) {
            row = r;
            col = c;
            sum += grid[r][c];
            nodeSum = sum;
        }
    }
    
    int maxSum = Integer.MIN_VALUE;
    int rows = grid.length;
    int cols = grid[0].length;
    if(rows < 2 && cols < 2) return grid[0][0];
    else {
        Deque<TravelNode> stack = new LinkedList<>();
        stack.addFirst(new TravelNode(0,0,0,grid));
        while(!stack.isEmpty()){
            TravelNode t = stack.removeFirst();
            // Update maxSum if the last node is reached
            if(t.row == rows-1 && t.col == cols - 1){
                if(t.nodeSum > maxSum) maxSum = t.nodeSum;
            } else {
                // Go Right
                if(t.col < cols-1){
                    stack.addFirst(new TravelNode(t.row, t.col+1, t.nodeSum, grid));
                }
                // Go Down
                if(t.row < rows-1){
                    stack.addFirst(new TravelNode(t.row + 1, t.col, t.nodeSum, grid));
                }
            }
        }
    }
    return maxSum;
}   