/* https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values in bottoms are the same.

If it cannot be done, return -1.

Example 1:
Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2]
Output: 2
Explanation: 
The first figure represents the dominoes as given by tops and bottoms: before we do any rotations.
If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.

Example 2:
Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4]
Output: -1
Explanation: 
In this case, it is not possible to rotate the dominoes to make one row of values equal.

Constraints:
2 <= tops.length <= 2 * 104
bottoms.length == tops.length
1 <= tops[i], bottoms[i] <= 6
*/

class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int[] first = new int[7];
        int[] second = new int[7];
        int[] same = new int[7]; //same number occurs here
        
        for(int i = 0 ; i < A.length ; i++) {
            first[A[i]]++;
            second[B[i]]++;
            if(A[i] == B[i]) same[A[i]]++;
        }
        
        for(int i = 1 ; i < 7 ; i++) {
            if(first[i] + second[i] - same[i] == A.length) {
                return Math.min(first[i], second[i]) - same[i];
            }
        }
        return -1;
    }
}
