// https://leetcode.com/problems/single-number/

/*
Given an array of integers, every element appears twice except for one. 
Find that single one.
*/
import java.io.*;
import java.util.*;

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        boolean dup = false;
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] == nums[i + 1]) // set dup to true meaning we are expecting the second occurence
                dup = true;
            else if(nums[i] != nums[i + 1] && dup == true) // the second occurence
                dup = false;
            else if(nums[i] != nums[i + 1] && dup == false) { // we are looking at the first occurence but the next number is not the same	 
                return nums[i];
        }
        return nums[nums.length - 1];
    }
}
