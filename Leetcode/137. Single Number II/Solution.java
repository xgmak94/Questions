/* https://leetcode.com/problems/single-number-ii

Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:
Input: [2,2,3,2]
Output: 3

Example 2:
Input: [0,1,0,1,0,1,99]
Output: 99
*/

class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        for(int n : map.keySet()) {
            if(map.get(n) == 1) {
                return n;
            }
        }
        return -1;
    }
}
