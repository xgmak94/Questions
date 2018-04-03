/* https://leetcode.com/problems/valid-triangle-number

Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

*/

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length < 3)
            return 0;
        int count = 0;
        for(int i = 0 ; i < nums.length - 2 ; i++) {
            for(int j = i + 1 ; j < nums.length - 1 ; j++) {
                for(int k = j + 1 ; k < nums.length ; k++) {
                    if(nums[i] + nums[j] > nums[k] && nums[i] != 0 && nums[j] != 0 && nums[k] != 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
