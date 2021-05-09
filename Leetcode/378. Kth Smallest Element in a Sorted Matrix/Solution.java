/* https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix

Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
return 13.

Note: 
You may assume k is always valid, 1 ≤ k ≤ n2.
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int n = matrix.length;
        if(n == 0 || k <= 0) return 0;
        
        for(int j = 0 ; j < n ; j++) {
            pq.offer(new int[]{matrix[0][j], 0, j}); //val, r, c
        }
        while(k > 1) { //1 to have next one be answer
            int[] curr = pq.poll();
            int r = curr[1];
            int c = curr[2];
            
            if(r+1 < n) pq.offer(new int[]{matrix[r+1][c], r+1, c}); //increment row
            k--;
        }
        return pq.poll()[0]; //val of kth element
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                list.add(matrix[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(k-1);
    }
}

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = matrix.length;
        
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < n ; j++) {
                pq.offer(matrix[i][j]);
            }
        }
        
        int smallest = 0;
        while(k > 0) {
            smallest = pq.poll();
            k--;
        }
        return smallest;
    }
}
