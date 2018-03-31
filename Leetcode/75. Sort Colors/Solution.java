/*
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
*/

public class Solution {
    public void sortColors(int[] nums) {
        int a = 0;
        int b = 0;
        int c = 0;
        
        for(int i : nums) {
            if(i == 0)
                a++;
            else if(i == 1)
                b++;
            else
                c++;
        }
        
        for(int i = 0 ; i < a ; i++)
            nums[i] = 0;
        for(int i = 0 ; i < b ; i++)
            nums[a + i] = 1;
        for(int i = 0 ; i < c ; i++)
            nums[a + b + i] = 2;
    }
}