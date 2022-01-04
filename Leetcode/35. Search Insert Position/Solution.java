/* https://leetcode.com/problems/search-insert-position

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

class Solution {
	public int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length-1;
		while(l <= r) {
			int mid = l + (r-l)/2;

			if(nums[mid] == target) {
				return mid;
			}
			else if(nums[mid] < target){
				r = mid+1;
			}
			else if(nums[mid] > target) {
				l = mid-1;
			}
		}
		return l;
	}
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] >= target) // find target or the number after target
                return i;
        }
        return nums.length; //last index if all numbers less than target
    }
}
