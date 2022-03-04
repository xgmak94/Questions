/* https://leetcode.com/problems/find-all-duplicates-in-an-array/

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[2,3]
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for(int n : nums) {
            int num = Math.abs(n);
            int idx = num - 1; //store at

            // store singletons as negative at index, num - 1
            // if duplicate then index will already be negative and become positive
            if(nums[idx] < 0) {
                list.add(num);
            }
            else {
                nums[idx] = -nums[idx];
            }
        }
        return list;
    }
}
