// https://leetcode.com/problems/majority-element

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.
*/
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            
            if(map.get(i) > (nums.length / 2))
                return i;
        }
        return (Integer) null;
    }
}

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int count = 0;
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == max) {
                count++;
            }
            else if(nums[i] != max) {
                max = nums[i];
                count = 1;
            }
            if(count > (nums.length / 2)) {
                break;
            }
        }
        return max;
    }
}
