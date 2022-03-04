/* https://leetcode.com/problems/partition-array-into-disjoint-intervals/

Given an array A, partition it into two (contiguous) subarrays left and right so that:

Every element in left is less than or equal to every element in right.
left and right are non-empty.
left has the smallest possible size.
Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

Example 1:
Input: [5,0,3,8,6]
Output: 3
Explanation: left = [5,0,3], right = [8,6]

Example 2:
Input: [1,1,1,0,6,12]
Output: 4
Explanation: left = [1,1,1,0], right = [6,12]

Note:
2 <= A.length <= 30000
0 <= A[i] <= 10^6
It is guaranteed there is at least one way to partition A as described.
*/

class Solution {
    public int partitionDisjoint(int[] A) {
        int[] maxLeft = new int[A.length];
        int m = A[0];
        for(int i = 0 ; i < A.length ; i++) { //maxLeft = max number to the left including index
            m = Math.max(A[i], m);
            maxLeft[i] = m;
        }
        
        int[] minRight = new int[A.length];
        int m = A[A.length-1];
        for(int i = A.length-1 ; i >= 0 ; i--) { //minRight = min number to the right including index
            m = Math.min(A[i], m);
            minRight[i] = m;
        }
        
        for(int i = 1 ; i < A.length ; i++) {
            if(maxLeft[i-1] <= minRight[i]) {
                return i;
            }
        }
        return -1;
    }
}
