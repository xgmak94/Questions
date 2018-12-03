/* https://leetcode.com/problems/find-peak-element

A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.

*/

class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] > nums[i+1])
                return i;
        }
        return nums.length - 1;
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < nums[mid + 1]) lo = mid + 1;
            else high = mid - 1;
        }
        return lo;
    }aa
}

class Solution {
	public int findPeakElement(int[] nums) {
		return findPeakUtil(nums, 0, nums.length - 1);
	}

	public int findPeakUtil(int[] nums, int low, int high) {
        if(low == high) return low;
        
		int mid = (high+low) / 2;
        
		if((mid == 0 && nums[mid] >= nums[mid+1]) || 
           (mid == nums.length - 1 && nums[mid] >= nums[mid-1]) || 
           (nums[mid] >= nums[mid+1] && nums[mid] >= nums[mid-1])) {
			return mid;
		}
		else {
			if(nums[mid] < nums[mid+1]) {
				return findPeakUtil(nums, mid+1, high);
			}
			return findPeakUtil(nums, low, mid-1);
		}
	}
}
