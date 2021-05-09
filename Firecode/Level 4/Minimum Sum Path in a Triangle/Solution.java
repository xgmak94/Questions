/*

Given a 'triangle' as an ArrayList of ArrayLists of integers, with each list representing a level of the triangle, find the minimum sum achieved by following a top-down path and adding the integer at each level along the path. Movement is restricted to adjacent numbers from the top to the bottom.

Note:
- You can only traverse through adjacent nodes while moving up or down the triangle.
- An adjacent node is defined as a node that is reached by moving down and left or down and right from a level. For eg, in the triangle shown below, if you are at the digit 3 in the second row, its adjacent nodes are 5 and 6

Example:
Input Triangle: 
[   [1],
   [2, 3],
  [4, 5, 6],
[7, 8, 9, 10],
]

Output : 14 (1->2->4->7)
Note: [..] denotes an ArrayList

*/

public static int minTriangleDepth(ArrayList<ArrayList<Integer>> input) {
    int height = input.size();
    int[] outBuffer = new int[input.get(height-1).size()];
    
    for(int i = 0; i < input.get(height-1).size(); i++){
        outBuffer[i] = input.get(height-1).get(i);
    }
    
    for(int r = height-2; r >= 0; r--){
        ArrayList<Integer> row = input.get(r);
        for(int i = 0; i < row.size(); i++){
            outBuffer[i] = row.get(i) + Math.min(outBuffer[i], outBuffer[i+1]);
        }
    }
    return outBuffer[0];
}