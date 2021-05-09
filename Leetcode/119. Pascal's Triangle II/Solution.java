/* https://leetcode.com/problems/pascals-triangle-ii/description/

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].
*/

//row 0-3
//  1
//  1   1
//  1   2   1
//  1   3   3   1
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> currRow = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1); //initiates first row;
        if(rowIndex == 0) return prevRow;
        
        for(int i = 0 ; i < rowIndex ; i++) {
            currRow.add(1);//always begin with 1
            for(int j = 0 ; j < prevRow.size() - 1 ; j++) {
                currRow.add(prevRow.get(j) + prevRow.get(j+1)); // middles
            }
            currRow.add(1);//always ends with 1
            
            prevRow = currRow; // sets previous row to current
            currRow = new ArrayList<>();
        }
        return prevRow;
    }
}
