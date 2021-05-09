/* https://leetcode.com/problems/pascals-triangle/description/

Given numRows, generate the first numRows of Pascal's triangle.

For example, given numRows = 5,
Return

[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if(numRows == 0) return triangle;
        
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        triangle.add(prevRow);
        //initiates first row;
        
        for(int i = 2 ; i <= numRows ; i++) {
            List<Integer> currRow = new ArrayList<>();
            
            currRow.add(1);//always begin with 1
            for(int j = 0 ; j < prevRow.size() - 1 ; j++) {
                currRow.add(prevRow.get(j) + prevRow.get(j+1)); // middles            
            }
            currRow.add(1);//always ends with 1
            
            triangle.add(currRow); // adds the row to triangle
            prevRow = currRow;
        }
        return triangle;
    }
}
