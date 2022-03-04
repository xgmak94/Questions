/* https://leetcode.com/problems/diagonal-traverse/

Given a matrix of M x N elements (M rows, N columns),
return all elements of the matrix in diagonal order as shown in the below image.

Example:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

Output:  [1,2,4,7,5,3,6,8,9]

Note:
The total number of elements of the given matrix will not exceed 10,000.
*/

class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return new int[]{};
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxKey = 0;
        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0 ; j < matrix[0].length ; j++) {
                int key = i+j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(matrix[i][j]);
                
                maxKey = Math.max(maxKey, key);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < maxKey ; i++) {
            List<Integer> curr = map.get(i);
            if(i % 2 == 0) Collections.reverse(curr);
            list.addAll(curr);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
