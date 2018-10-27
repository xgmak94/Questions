/* https://leetcode.com/problems/next-greater-element-ii/description/

Given a circular array (the next element of the last element is the first element of the array), 
print the Next Greater Number for every element. 
The Next Greater Number of a number x is the first greater number to its traversing-order next in the array, 
which means you could search circularly to find its next greater number. 
If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number; 
The second 1's next greater number needs to search circularly, which is also 2.

*/

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int[] arr = new int[nums.length];
        
        for(int i = 0 ; i < nums.length ; i++) {
        	arr[i] = -1;
            for(int j = i + 1 ; j % nums.length != i ; j++) { //loop through array circular
                if(nums[j % nums.length] > nums[i]) {
                    arr[i] = nums[j % nums.length];
                    break;
                }
            }
        }
        return arr;
    }
}
