/* https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference/

Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

Example 1:
Input: arr = [1,2,3,4], difference = 1
Output: 4
Explanation: The longest arithmetic subsequence is [1,2,3,4].

Example 2:
Input: arr = [1,3,5,7], difference = 1
Output: 1
Explanation: The longest arithmetic subsequence is any single element.

Example 3:
Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
Output: 4
Explanation: The longest arithmetic subsequence is [7,5,3,1].

Constraints:
1 <= arr.length <= 10^5
-10^4 <= arr[i], difference <= 10^4
*/

class Solution {
    public int longestSubsequence(int[] arr, int difference) {
       Map<Integer, Integer> map = new HashMap<>(); //val, longest subseq ending with val
        
        for(int val : arr) {
            if(!map.containsKey(val - difference)) {
                map.put(val, 1);
            }
            else {
                map.put(val, map.get(val-difference) + 1);
            }
        }
        
        int max = 0;
        for(int val : map.values()) {
            max = Math.max(max, val);
        }
        return max;
    }   
}

// times out
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        int[] dp = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++)
            dp[i] = 1;
        
        for(int i = 1 ; i < arr.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(arr[j] == arr[i] - difference) {
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }
        
        
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(dp[i] > max)
                max = dp[i];
        }
        return max;
    }
}