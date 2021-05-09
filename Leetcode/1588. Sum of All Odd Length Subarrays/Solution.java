/* https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.

A subarray is a contiguous subsequence of the array.

Return the sum of all odd-length subarrays of arr.

Example 1:
Input: arr = [1,4,2,5,3]
Output: 58
Explanation: The odd-length subarrays of arr and their sums are:
[1] = 1
[4] = 4
[2] = 2
[5] = 5
[3] = 3
[1,4,2] = 7
[4,2,5] = 11
[2,5,3] = 10
[1,4,2,5,3] = 15
If we add all these together we get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58

Example 2:
Input: arr = [1,2]
Output: 3
Explanation: There are only 2 subarrays of odd length, [1] and [2]. Their sum is 3.

Example 3:
Input: arr = [10,11,12]
Output: 66

Constraints:
1 <= arr.length <= 100
1 <= arr[i] <= 1000
*/

class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int[] prefixSum = new int[arr.length+1];
        int sum = 0;
        
        prefixSum[0] = 0;
        for(int i = 0 ; i < arr.length ; i++) { //sum of all before index n
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        
        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = i+1 ; j < arr.length + 1 ; j += 2) {
                sum += prefixSum[j] - prefixSum[i]; //sum of subarray i+1 to j
            }
        }
        return sum;
    }
}
