/* https://leetcode.com/problems/two-sum/description/

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
import java.util.*;
import org.junit.Assert.*;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //stores the number, index
        for(int i = 0 ; i < nums.length ; i++) {
            Integer idx = map.get(target - nums[i]);
            if(idx != null) { //if the map contains the complementary number then they do add up
                return new int[]{idx, i};
            }
            else if(idx == null) {
                map.put(nums[i], i); //if map does not contain complement
            }
        }
        return new int[]{0, 0}; // if two numbers do not add up to the target
    }
    
    public static void main(String[] args) {
        int[] ex1 = {2, 7, 11, 15};
        int targ1 = 9;
        int[] ans1 = {0, 1};

        int[] ex2 = {3, 2, 4};
        int targ2 = 6;
        int[] ans2 = {1, 2};

    	int[] ex3 = {3, 3};
        int targ3 = 6;
        int[] ans3 = {0, 1};

        assertEquals(ans1, twoSum(ex1, targ1));
        assertEquals(ans2, twoSum(ex2, targ2));
        assertEquals(ans3, twoSum(ex2, targ3));
    } 
}