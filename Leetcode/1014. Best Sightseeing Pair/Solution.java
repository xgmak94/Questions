/* https://leetcode.com/problems/best-sightseeing-pair/

Given an array A of positive integers, A[i] represents the value of the i-th sightseeing spot, and two sightseeing spots i and j have distance j - i between them.

The score of a pair (i < j) of sightseeing spots is (A[i] + A[j] + i - j) : the sum of the values of the sightseeing spots, minus the distance between them.

Return the maximum score of a pair of sightseeing spots.

Example 1:
Input: [8,1,5,2,6]
Output: 11
Explanation: i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
*/

class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int maxScore = 0;//curr maxScore
        int highestVal = 0;//highest val seen taking into account dist
        
        for(int i = 0 ; i < A.length ; i++) { //as we move scores decrement by 1 because distance
            maxScore = Math.max(maxScore, highestVal + A[i] - 1); //curr score
            highestVal = Math.max(highestVal - 1, A[i]); // current highestval-1 for each iteration
        }
        return maxScore;
    }
}
