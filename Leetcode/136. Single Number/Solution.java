/* https://leetcode.com/problems/single-number/

Given a non-empty array of integers, every element appears twice except for one. 
Find that single one.

Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

Example 1:
Input: [2,2,1]
Output: 1

Example 2:
Input: [4,1,2,1,2]
Output: 4
*/

//a ^ a = 0 XOR
class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for(int num : nums) {
            ret = ret ^ num;
        }
        return ret;
    }
}

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        
        boolean dup = false;
        for(int i = 0 ; i < nums.length - 1 ; i++) {
            if(nums[i] == nums[i + 1]) {// set dup to true meaning we are expecting the second occurence
                dup = true;
            }
            else if(nums[i] != nums[i + 1] && dup == true) {// the second occurence
                dup = false;
            }
            else if(nums[i] != nums[i + 1] && dup == false) { // we are looking at the first occurence but the next number is not the same	 
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}
