/* https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

Example 1:

Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
Example 2:

Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
Example 3:

Input: nums = [3,3,2,2,1,1], k = 3
Output: true

*/

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
    	Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0 ; i < nums.length ; i++) {
        	int val = nums[i];
            int freq = map.get(val);
            if(freq > 0) {
                for(int n = 1 ; n < k ; n++) {
                    if(map.get(val + n) != null && map.get(val+ n) > 0) {
                        freq = Math.min(freq, map.get(val + n));
                    }
                    else {
                        return false;
                    }
                }
                for(int n = 0 ; n < k ; n++) { //remove freq
                    map.put(val + n, map.get(val + n) - freq);
                }
            }
        }
        return true;
    }
}

class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
    	Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for(int i = 0 ; i < nums.length ; i++) {
        	int val = nums[i];
            if(map.get(val) > 0) {
                for(int n = 0 ; n < k ; n++) {
                    if(map.get(val + n) != null && map.get(val+ n) > 0) {
                        map.put(val + n, map.get(val + n) - 1);
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
