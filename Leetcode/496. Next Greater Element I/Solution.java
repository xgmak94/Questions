/* https://leetcode.com/problems/next-greater-element-i

You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.

Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.

Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); //num, nextGreater
        Stack<Integer> s = new Stack<>();
        
        for(int num : nums2) {
            while(!s.isEmpty() && s.peek() < num) { //if current number is greater than the stack, all nums on the stack less than num have next greatest as current number
                map.put(s.pop(), num);
            }
            s.push(num);
        }
        
        int[] greater = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++) {
            greater[i] = map.getOrDefault(nums1[i], -1); //-1 if there is no next greater
        }
        return greater;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        int[] ret = new int[findNums.length];
        Arrays.fill(ret, -1);
        
        for(int i = 0 ; i < findNums.length ; i++) {
            for(int j = 0 ; j < nums.length ; j++) {
                if(nums[j] == findNums[i]) {
                    while(j < nums.length && nums[j] <= findNums[i]) {
                        j++;
                    }
                    if(j < nums.length && nums[j] > findNums[i]) {
                        ret[i] = nums[j];
                    }
                }
            }
        }
        return ret;
    }
}
