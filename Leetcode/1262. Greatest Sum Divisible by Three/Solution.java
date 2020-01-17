/* https://leetcode.com/problems/greatest-sum-divisible-by-three/

Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.

Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
Example 2:

Input: nums = [4]
Output: 0
Explanation: Since 4 is not divisible by 3, do not pick any number.
Example 3:

Input: nums = [1,2,3,4,4]
Output: 12
Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
 
Constraints:

1 <= nums.length <= 4 * 10^4
1 <= nums[i] <= 10^4

*/

class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        int smallest2 = 10000; // 1 <= nums[i] <= 10^4
        int smallest1 = 10000; // 1 <= nums[i] <= 10^4n
        
        for(int n : nums) {
            sum += n;
            
            if(n % 3 == 1) {
                smallest2 = Math.min(smallest2, smallest1 + n); //smallest1 + n removes 2 that add up to 0
                smallest1 = Math.min(smallest1, n);
            }
            else if(n % 3 == 2) {
                smallest1 = Math.min(smallest1, smallest2 + n); //smallest 2 + n removes 2 that add up to 0
                smallest2 = Math.min(smallest2, n);
            }
        }
        
        if(sum % 3 == 1) {
            sum -= smallest1;
        }
        else if(sum % 3 == 2) {
            sum -= smallest2;
        }
        return sum;
    }
}
