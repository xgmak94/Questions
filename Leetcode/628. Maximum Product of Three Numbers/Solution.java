// https://leetcode.com/problems/maximum-product-of-three-numbers

/*
Given an integer array, find three numbers whose product is maximum and output the maximum product.
*/

import java.io.*;
import java.util.*;


public class Solution {
    public int maximumProduct(int[] nums) {
        int prod = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int size = nums.length;
        
        int max1 = nums[size - 1];
        int max2 = nums[size - 2];
        int max3 = nums[size - 3];
        
        int min1 = nums[0];
        int min2 = nums[1];
        
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
}
