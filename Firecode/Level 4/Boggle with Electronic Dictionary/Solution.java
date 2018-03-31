/*

You're given a 2D Boggle Board which contains an m x n matrix of chars - char[][] board, and a fast, electronic Dictionary in the form of a Prefix Tree or Trie. Write a method - boggleSearchWithDict that searches the Boggle Board for words in the dictionary. Your method should return an alphabetically sorted ArrayList of words that are present on the board as well as in the dictionary. Words on the board can be constructed with sequentially adjacent letters, where adjacent letters are horizontal or vertical neighbors (not diagonal). Also, each letter on the Boggle Board must be used only once. Your program should run in a reasonable amount of time (at max about 50 ms for each test case) and shouldn't time out. 

Note: The Trie has two built-in methods that you'll find useful for this problem - searchWord(String s) and searchPrefix(String s). These will return true if the complete word or prefix are found in the dictionary, respectively.

Example:

Input Board :      
{
    {A, O, L},
    {D, E, L},
    {G, H, I},
}
Dictionary : [HELLO, HOW, ARE, YOU] (as a Trie)
Output: [HELLO]
*/

public ArrayList<String> boggleSearchWithDict(char[][] board, Trie dictionary){
    TreeSet<String> outputHolder = new TreeSet<>();
    int rows = board.length;
    int cols = board[0].length;
    for(int i = 0; i < rows; i++){
        for(int j = 0; j < cols; j++){
            search(i,j,board,dictionary,"",outputHolder);
        }
    }
    return new ArrayList<>(outputHolder);
}

public void search(int r, int c, char[][] board, Trie dictionary, String prefix, TreeSet<String> outputHolder){
    int rows = board.length;
    int cols = board[0].length;
    
    // Terminating Conditions
    if( r > rows-1                          // Out of Bounds
     || r < 0                               // Out of Bounds
     || c > cols-1                          // Out of Bounds
     || c < 0                               // Out of Bounds 
     || !dictionary.searchPrefix(prefix)    // Not matching pattern
     || board[r][c] == '@'){                // Visited
        return;
    }
    char ch = board[r][c];
    String s = prefix + ch;
    if(dictionary.searchWord(s)){           
        outputHolder.add(s);                // Add to the treeSet 
    }
    board[r][c] = '@';                      // Mark the board node as visited
    
    search(r-1,c,board,dictionary,s,outputHolder);  // Check Up 
    search(r+1,c,board,dictionary,s,outputHolder);  // Check Down
    search(r,c-1,board,dictionary,s,outputHolder);  // Check Left
    search(r,c+1,board,dictionary,s,outputHolder);  // Check Right
    
    board[r][c] = ch;                       // Unmark the board node
}