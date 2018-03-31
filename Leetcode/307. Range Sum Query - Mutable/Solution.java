/* https://leetcode.com/problems/range-sum-query-mutable

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

The update(i, val) function modifies nums by updating the element at index i to val.
Example:
Given nums = [1, 3, 5]

sumRange(0, 2) -> 9
update(1, 2)
sumRange(0, 2) -> 8
Note:
The array is only modifiable by the update function.
You may assume the number of calls to update and sumRange function is distributed evenly.

*/

class NumArray {
    int[] arr;
    int[] sums;
    public NumArray(int[] nums) {
        if(nums.length == 0)
            return;
        
        arr = new int[nums.length];
        sums = new int[nums.length];
        arr[0] = sums[0] = nums[0];
        
        for(int i = 1 ; i < nums.length ; i++) {
            arr[i] = nums[i];
            sums[i] = sums[i - 1] + nums[i];
        }
    }
    
    public void update(int i, int val) {
        if(i < 0 || i >= sums.length)
            return;

        if(i == 0) {
            sums[i] = arr[i] = val;
            for(int j = 1 ; j < sums.length ; j++) {
                sums[j] = sums[j - 1] + arr[j];
            }
        }
        else {
            arr[i] = val;
            while(i < sums.length) {
                sums[i] = sums[i - 1] + arr[i];
                i++;
            }
        }
    }
    
    public int sumRange(int i, int j) {
        return (i == 0) ? sums[j] : sums[j] - sums[i - 1];
    }
}
