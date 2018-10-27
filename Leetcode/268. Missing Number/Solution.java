// https://leetcode.com/problems/missing-number

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.
*/

import java.io.*;
import java.util.*;

class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int sum0toN = n; // n + 0+1+2+3+4...
        int actualSum = 0;//0 + num[0]+num[1]+num[2]...

        for(int i = 0 ; i < n ; i++) {
            sum0toN += i;
            actualSum += nums[i];
        }
        
        return sum0toN - actualSum;
    }
}

public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        
        int missingSum = 0;
        for(int i = 0 ; i < n ; i++) {
            missingSum += nums[i];
        }
        
        int actualSum = (n * (n + 1)) / 2;
        
        return actualSum - missingSum;
    }
}