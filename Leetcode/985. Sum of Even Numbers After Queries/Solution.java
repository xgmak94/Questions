/* https://leetcode.com/problems/sum-of-even-numbers-after-queries/

We have an array A of integers, and an array queries of queries.

For the i-th query val = queries[i][0], index = queries[i][1], we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.

(Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)

Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.

 

Example 1:

Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
Output: [8,6,2,4]
Explanation: 
At the beginning, the array is [1,2,3,4].
After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.

*/

class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int currSum = 0;
        int[] sums = new int[queries.length];
        
        for(int n : A) {
            if(n % 2 == 0)
                currSum += n;
        }
        
        for(int i = 0 ; i < queries.length ; i++) {
            int add = queries[i][0];
            int idx = queries[i][1];
            
            if(A[idx] % 2 == 0) currSum -= A[idx]; //if val is even remove it      
            A[idx] += add;
            if(A[idx] % 2 == 0) currSum += A[idx]; //if new val is even add it
            
            sums[i] = currSum;
        }
        return sums;
    }
}