/* https://leetcode.com/problems/find-subsequence-of-length-k-with-the-largest-sum/

You are given an integer array nums and an integer k. You want to find a subsequence of nums of length k that has the largest sum.

Return any such subsequence as an integer array of length k.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

 

Example 1:

Input: nums = [2,1,3,3], k = 2
Output: [3,3]
Explanation:
The subsequence has the largest sum of 3 + 3 = 6.
Example 2:

Input: nums = [-1,-2,3,4], k = 3
Output: [-1,3,4]
Explanation: 
The subsequence has the largest sum of -1 + 3 + 4 = 6.
Example 3:

Input: nums = [3,4,3,3], k = 2
Output: [3,4]
Explanation:
The subsequence has the largest sum of 3 + 4 = 7. 
Another possible subsequence is [4, 3].
 

Constraints:

1 <= nums.length <= 1000
-105 <= nums[i] <= 105
1 <= k <= nums.length
*/

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[][] valIndex = new int[nums.length][2];
        for(int i = 0 ; i < nums.length ; i++) { //create new array with [val,index]
            valIndex[i] = new int[]{nums[i], i};
        }
        Arrays.sort(valIndex, (a,b) -> b[0]-a[0]); //sort descending vals
        
        int[][] kMax = Arrays.copyOf(valIndex, k); //copy array with only k largest values
        Arrays.sort(kMax, (a,b) -> a[1]-b[1]); //sort by indices
        
        int[] arr = new int[k]; //copy values after sorted by indices
        for(int i = 0 ; i < k ; i++) {
            arr[i] = kMax[i][0];
        }
        return arr;
    }
}
