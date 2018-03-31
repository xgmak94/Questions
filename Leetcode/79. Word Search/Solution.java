/* https://leetcode.com/problems/word-search/description/

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

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
    int m = board.length;
    int n = board[0].length;
 
    boolean result = false;
    for(int i = 0 ; i < m ; i++){
        for(int j = 0 ; j < n ; j++){
           if(dfs(board, word, i, j, m, n, 0)){
               return true;
           }
        }
    } 
    return false;
}
 
    public boolean dfs(char[][] board, String word, int i, int j, int m, int n, int k){
        if(i < 0 || j < 0 || i >= m || j >= n){
            return false;
        }

        if(board[i][j] == word.charAt(k)){
            char temp = board[i][j];
            board[i][j] = ' ';
            if(dfs(board, word, i - 1, j, m, n, k + 1) || dfs(board, word, i + 1, j, m, n, k + 1)
                    || dfs(board, word, i, j - 1, m, n, k + 1) || dfs(board, word, i, j + 1, m, n, k + 1)){
                return true;
            }
            board[i][j] = temp;
        }
        return false;
    }
}