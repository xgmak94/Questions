/* https://leetcode.com/problems/single-number-ii

Given an array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            if(map.containsKey(n)) {
                if(map.get(n) == 2)
                    map.remove(n);
                else
                    map.put(n, map.get(n) + 1);
            }
            else
                map.put(n, 1);
        }
        for(int n : map.keySet())
            return n;
        
        return (Integer) null;
    }
}
