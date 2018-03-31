/*
ou're given a 2D board which contains an m x n matrix of chars - char[][] board. Write a method - printPaths that prints all possible paths from the top left cell to the bottom right cell. Your method should return an ArrayList of Strings, where each String represents a path with characters appended in the order of movement. You're only allowed to move down and right on the board. The order of String insertion in the ArrayList does not matter.
 
Example:

Input Board :      
{
    {A, X},
    {D, E}
}
Output: ["ADE", "AXE"]
*/

public ArrayList<String> printPaths(char[][] board){
    ArrayList<String> out = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    search(0,0,board,sb,out);
    return out;
}

public void search(int i, int j, char[][] board, StringBuilder sb, ArrayList<String> out){
    int rows = board.length;
    int cols = board[0].length;
    if(i > rows-1 || j > cols-1) return;
    
    sb.append(board[i][j]); // Mark
    if(i == rows-1 && j == cols-1){
        out.add(sb.toString());
        sb.deleteCharAt(sb.length()-1);
        return;
    }
    search(i+1,j,board,sb,out); // Search Down
    search(i,j+1,board,sb,out); // Search Right
    sb.deleteCharAt(sb.length()-1); // Un-Mark
}	