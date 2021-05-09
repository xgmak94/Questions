/* https://leetcode.com/problems/single-number-iii

Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:
Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:
The order of the result is not important. So in the above example, [5, 3] is also correct.
Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ret = new int[2];
        Set<Integer> set = new HashSet<>();
        
        for(int i : nums) {
            if(set.contains(i)) {
                set.remove(i);
            }
            else {
                set.add(i);
            }
        }
        
        int n = 0;
        for(Integer i : set) {
            ret[n++] = i;
        }
        return ret;
    }
}
