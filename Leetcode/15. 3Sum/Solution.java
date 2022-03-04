/* https://leetcode.com/problems/3sum/

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.

For example, given array S = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        
        //SET the first val, then reference #167. Two Sum II - Input Array Is Sorted
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int l = i+1;
            int r = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r])); //add to list and change to next unique set
                    j++;
                    while(l < r && nums[l] == nums[l-1]) { //move left ptr to new value
                        j++;
                    }
                }
                else if(sum < 0) {
                    l++;
                }
                else if(sum > 0) {
                    r--;
                }
            }
        }
        return list;
    }
}
