/* https://leetcode.com/problems/first-missing-positive/

Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
Input: [1,2,0]
Output: 3

Example 2:
Input: [3,4,-1,1]
Output: 2

Example 3:
Input: [7,8,9,11,12]
Output: 1

Note:
Your algorithm should run in O(n) time and uses constant extra space.
*/

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) {
            if(nums[i] <= 0 || nums[i] > nums.length) { //these numbers do not matter just make them positive
                nums[i] = n+1;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) continue; //if positive
            
            if (nums[num-1] > 0) { // only need to make neg once for multiple occurences
                nums[num-1] = -1 * nums[num-1];
            }
        }
        
        for(int i = 0 ; i < n ; i++) { // search for number
            if(nums[i] > 0) {//number was not seen
                return i+1;
            }
        }
        return n+1;
    }
}

class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums.length == 0) return 1;
        Set<Integer> set = new HashSet<>();
        
        for(int num : nums) {
            set.add(num);
        }
        
        for(int i = 1 ; i <= nums.length ; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return nums.length+1;
    }
}
