/* https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/

Given an array A of integers, we must modify the array in the following way: we choose an i and replace A[i] with -A[i], and we repeat this process K times in total.
(We may choose the same index i multiple times.)

Return the largest possible sum of the array after modifying it in this way.

Example 1:
Input: A = [4,2,3], K = 1
Output: 5
Explanation: Choose indices (1,) and A becomes [4,-2,3].

Example 2:
Input: A = [3,-1,0,2], K = 3
Output: 6
Explanation: Choose indices (1, 2, 2) and A becomes [3,1,0,2].

Example 3:
Input: A = [2,-3,-1,5,-4], K = 2
Output: 13
Explanation: Choose indices (1, 4) and A becomes [2,3,-1,5,4].
*/
import java.util.*;
class Solution {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        Arrays.sort(nums);
        //change as many negative values to positive starting from most negative number
        for(int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if(k > 0 && nums[i] < 0) {
                k--;
                nums[i] = -nums[i];
                sum += 2*nums[i];
            }
            min = Math.min(nums[i], min); //store the min element
        }
        //if any k left we can constantly switch the min positive element and if k is odd then 2*min to add neg
        if(k % 2 == 1) sum -= min*2;
        return sum;
    }
    public static void main(String[] args) {
        int ex1 = largestSumAfterKNegations(new int[]{4,2,3}, 1);
        int ex2 = largestSumAfterKNegations(new int[]{3,-1,0,2}, 3);
        int ex3 = largestSumAfterKNegations(new int[]{2,-3,-1,5,-4}, 2);

        System.out.println(ex1);
        System.out.println(ex2);
        System.out.println(ex3);
    }
}
