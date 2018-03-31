/* https://leetcode.com/problems/longest-harmonious-subsequence/description/

We define a harmonious array is an array where the difference between its maximum value and its minimum value is exactly 1.

Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible subsequences.

Example 1:
Input: [1,3,2,2,5,2,3,7]
Output: 5
Explanation: The longest harmonious subsequence is [3,2,2,2,3].
Note: The length of the input array will not exceed 20,000.

*/

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int longest = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if(map.containsKey(nums[i] + 1))
                longest = Math.max(longest, map.get(nums[i]) + map.get(nums[i] + 1));
            if(map.containsKey(nums[i] - 1))
                longest = Math.max(longest, map.get(nums[i]) + map.get(nums[i] - 1));
        }
        return longest;
    }
}
