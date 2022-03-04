/* https://leetcode.com/problems/increasing-triplet-subsequence/

Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:
Return true if there exists i, j, k 
such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false.
*/

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false; //cannot contain triple with less than 3 elements
        
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for(int num : nums) { //we are looking for number greater than both x AND y
            if(num <= x) { // found a smaler number for x to be
                x = num;
            }
            else if(num > x && num < y) { //found a smaller number for y to be
                y = num;
            }
            else if(num > y) { //number is greater than x and y, triplet exists
                return true;
            }
        }
        return false;
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length == 0)
            return false;
        
        int[] memo = new int[nums.length];
        Arrays.fill(memo, 1);
        
        for(int i = 1 ; i < nums.length ; i++) {
            for(int j = 0 ; j < i ; j++) {
                if(nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                    if(memo[i] == 3) {
                        return true;
                    }
                }
            }
        }     
        return false;
    }
}
