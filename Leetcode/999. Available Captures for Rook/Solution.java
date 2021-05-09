/* https://leetcode.com/problems/available-captures-for-rook/

On an 8 x 8 chessboard, there is one white rook.  
There also may be empty squares, white bishops, and black pawns.  
These are given as characters 'R', '.', 'B', and 'p' respectively. 
Uppercase characters represent white pieces, and lowercase characters represent black pieces.

The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south), 
then moves in that direction until it chooses to stop, reaches the edge of the board, or 
captures an opposite colored pawn by moving to the same square it occupies.  
Also, rooks cannot move into the same square as other friendly bishops.

Return the number of pawns the rook can capture in one move.
*/

class Solution {
    int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    int boardLen = 8; //board length
    public int numRookCaptures(char[][] board) {
        int count = 0;
        for(int i = 0 ; i < boardLen ; i++) {
            for(int j = 0 ; j < boardLen ; j++) {
                if(board[i][j] == 'R') {
                    count = capture(board, i, j);
                    break; //only 1 rook else remove this
                }
            }
        }
        return count;
    }
    
    public int capture(char[][] board, int row, int col) {
        int count = 0;
        for(int[] dir : dirs) {
            int newRow = dir[0] + row;
            int newCol = dir[1] + col;
            
            while(inBounds(newRow, newCol) && board[newRow][newCol] == '.') {
                newRow += dir[0];
                newCol += dir[1];
            }
            if(inBounds(newRow, newCol) && board[newRow][newCol] == 'p') {
                count++;
            }
        }
        return count;
    }
    
    public boolean inBounds(int row, int col) {
        if((row >= 0 && row < boardLen) && (col >= 0 && col < boardLen)) {
            return true;
        }
        return false;
    }
}
