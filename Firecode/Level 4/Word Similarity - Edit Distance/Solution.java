/*
Edit distance is a classic algorithm that is used in many applications, including Spell Correction, DNA Sequencing and Natural Language Processing. Given two Strings, a and b, write a method - editDistance that returns the minimum number of operations needed to transform a into b. The following character operations are allowed : 

a) Replace character
b) Insert character
c) Delete character

Examples : 

editDistance("sale", "sales") => 1

Operations : 
1) Insert "s"
*/

/*

edits
    s a l e
  0 1 2 3 4
s 1 0 1 2 3
o 2 1 1 2 3
l 3 2 2 1 2
d 4 3 3 3 2


public int editDistance(String a, String b){
    int m = a.length();
    int n = b.length();
    
    int [][]memo = new int[m+1][n+1];
    
    for(int i = 0 ; i <= m ; i++) {
        memo[i][0] = i;
    }
    for(int j = 0 ; j <= n ; j++) {
        memo[0][j] = j;
    }
    
    for(int i = 1 ; i <= m ; i++) {
        for(int j = 1 ; j <= n ; j++) {
            if(a.charAt(i - 1) == b.charAt(j - 1)) {
                memo[i][j] = memo[i-1][j-1];
            }
            else {
                memo[i][j] = 1 + Math.min(Math.min(memo[i][j-1], memo[i-1][j]), memo[i-1][j-1]);
            }
        }
    }
    return memo[m][n];
}