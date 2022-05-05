/* https://leetcode.com/problems/word-search

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
The same letter cell may not be used more than once.

For example,
Given board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0 ; i < board.length ; i++) {
            for(int j = 0 ; j < board[0].length ; j++) {
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int i, int j, int idx) {
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        if(board[i][j] == word.charAt(idx)) {
            if(idx == word.length()-1) return true;
            
            char temp = board[i][j];
            board[i][j] = ' ';
            for(int[] dir : dirs) {
                if(dfs(board, word, i+dir[0], j+dir[1], idx+1)) return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}
