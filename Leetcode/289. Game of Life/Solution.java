/* https://leetcode.com/problems/game-of-life/

According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.

Follow up: 
Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
*/

class Solution {
	private static int[][] directions = new int[][]{{-1,-1},{-1,0},{-1,1},  
                                                    {0,-1},{0,1},  
                                                    {1,-1},{1,0},{1, 1}};

    public int sumSurroundings(int[][] matrix, int x, int y, int m, int n){
        int sum = 0;
        int numSurrounding = 0;
        for (int[] direction : directions) {
            int dx = x + direction[0];
            int dy = y + direction[1];
            if(dx >= 0 && dx < m && dy >= 0 && dy < n) {
            	sum += matrix[dx][dy];
            	numSurrounding++;
            }
        }
        return sum;
    }

    public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        
        int m = board.length;
        int n = board[0].length;
        int[][] updatedBoard = new int[m][n];

        for(int i = 0 ; i < m ; i++) {
        	for(int j = 0 ; j < n ; j++) {
        		int sum = sumSurroundings(board, i, j, m, n);
        		if(board[i][j] == 0) { // 0 dead cell               
    				if(sum == 3) {  // Any dead cell with exactly 3 live neighbors becomes a live cell
    					updatedBoard[i][j] = 1;
                    }
        		}
        		else if (board[i][j] == 1) {// 1 live cell
        			if(sum < 2) { // Any live cell with fewer than 2 live neighbors dies
        				updatedBoard[i][j] = 0;
                    }
        			else if(sum == 2 || sum == 3) { // Any live cell with 2 or 3 live neighbors lives
        				updatedBoard[i][j] = 1;
                    }
        			else if(sum > 3) { // Any live cell with more than three live neighbors dies
        				updatedBoard[i][j] = 0;
                    }
        		}
        	}
        }
        
        for(int i = 0 ; i < m ; i++) {
            board[i] = Arrays.copyOf(updatedBoard[i], updatedBoard[i].length);
        }
    }
}
