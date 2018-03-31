/*
The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.

Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.

Example 1:
Input: nums = [1,2,2,4]
Output: [2,3]
*/

public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ret = new int[2];
        Arrays.sort(nums);
        
        int sum = nums[0];
        int expectedSum = 1;
        
        for(int i = 1 ; i < nums.length ; i++) {            
            sum += nums[i];
            expectedSum += (i + 1);
            
            if(nums[i] == nums[i - 1])
                ret[0] = nums[i];
        }
        ret[1] = expectedSum - (sum - ret[0]);
        
        return ret;
    }
}

public class Solution {
    public int[] findErrorNums(int[] nums) {
        Arrays.sort(nums);
        int dup = -1, missing = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1])
                dup = nums[i];
            else if (nums[i] > nums[i - 1] + 1)
                missing = nums[i - 1] + 1;
        }
        return new int[] {dup, nums[nums.length - 1] != nums.length ? nums.length : missing};
    }
}
