//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
/*
Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements of [1, n] inclusive that do not appear in this array.

Could you do it without extra space and in O(n) runtime? 
You may assume the returned list does not count as extra space.
*/

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int i = 0 ; i < n ; i++) {
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = -Math.abs(nums[idx]); //if the idx is negative it is in the array
        }
        
        List<Integer> dissapeared = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            if(nums[i] > 0) {
                dissapeared.add(i+1);
            }
        }
        return dissapeared;
    }
}

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] counted= new int[n + 1];
        for(int i = 1 ; i <= n ; i++)
            counted[nums[i]]++;
        
        List<Integer> dissapeared = new ArrayList<>();
        for(int i = 1 ; i <= n ; i++) { //we wanted the array to contain 1 to n inclusive
            if(counted[i] == 0) {
                dissapeared.add(i);
            }
        }
        return dissapeared;
    }
}
