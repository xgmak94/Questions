/* https://leetcode.com/problems/two-sum-ii-input-array-is-sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. 
Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lo = 0;
        int hi = numbers.length - 1;
        
        while(lo < hi) {
            int sum = numbers[lo] + numbers[hi];
            if(sum > target) {
                hi--;
            }
            else if(sum < target) {
                lo++;
            }
            else {
                break;
            }
        }
        return new int[]{lo + 1, hi + 1}; //1 indexed
    }
}
