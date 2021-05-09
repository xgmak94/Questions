/* https://leetcode.com/problems/array-nesting/description/

A zero-indexed array A consisting of N different integers is given. 
The array contains all integers in the range [0, N - 1].

Sets S[K] for 0 <= K < N are defined as follows:

S[K] = { A[K], A[A[K]], A[A[A[K]]], ... }.

Sets S[K] are finite for each K and should NOT contain duplicates.

Write a function that given an array A consisting of N integers, return the size of the largest set S[K] for this array.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
*/

class Solution {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        int res = 0;      
        for(int i = 0 ; i < nums.length ; i++) {
            if(!visited[i]) {
                int start = nums[i];
                int count = 0;
                
                start = nums[start];
                count++;
                visited[start] = true;
                
                while(start != nums[i]) {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
