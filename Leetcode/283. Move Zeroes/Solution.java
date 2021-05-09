/* https://leetcode.com/problems/move-zeroes 

Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int idx = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] != 0) { //place non zeros in order at beginning of array
                nums[idx++] = nums[i];
            }
        }
        while(idx < nums.length) { // fill rest with 0's
            nums[idx] = 0;
            idx++;
        }
    }
}

public class Solution {
    public void moveZeroes(int[] nums) {
        int numZeros = 0;
        
        ArrayList<Integer> arraylist = new ArrayList<Integer>();
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] != 0) {
                arraylist.add(nums[i]);
            }
            else {
                numZeros++;
            }
        }
        
        for(int i = 0 ; i < numZeros ; i++) {
            arraylist.add(0);
        }
        
        Integer[] ans = arraylist.toArray(new Integer[arraylist.size()]);
        
        for(int i = 0 ; i < nums.length ; i++) {
            nums[i] = ans[i];
        }
    }
}
