/* https://leetcode.com/problems/product-of-array-except-self/

Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;

        for (int i = 1; i < n; i++) { //everything to the left of i
            res[i] = res[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }
}

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int[] prod = new int[n];
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        for(int i = 1 ; i < n ; i++)
            left[i] = nums[i - 1] * left[i - 1];
        
        right[n - 1] = 1;
        for(int i = n - 2 ; i > -1 ; i--)
            right[i] = nums[i + 1] * right[i + 1];
        
        for(int i = 0 ; i < n ; i++)
            prod[i] = left[i] * right[i];
        
        return prod;
    }
}
