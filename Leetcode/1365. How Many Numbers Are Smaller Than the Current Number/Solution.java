/* https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
Return the answer in an array.

Example 1:
Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation: 
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1). 
For nums[3]=2 there exist one smaller number than it (1). 
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).

Example 2:
Input: nums = [6,5,4,8]
Output: [2,1,0,3]

Example 3:
Input: nums = [7,7,7,7]
Output: [0,0,0,0]

Constraints:
2 <= nums.length <= 500
0 <= nums[i] <= 100
*/

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] count = new int[101]; //count of all numbers up to 100
        int[] smaller = new int[len];
        
        for(int num : nums) {
            count[num]++;
        }
        
        for(int i = 1 ; i <= 100 ; i++) {
            count[i] += count[i-1];
        }
        
        for(int i = 0 ; i < len ; i++) {
            int num = nums[i];
            if(num == 0) smaller[i] = 0; //no numbers smaller than 0
            else smaller[i] = count[num-1];
        }
        return smaller;
    }
}

class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] smaller = new int[len];
        
        for(int i = 0 ; i < len ; i++) {
            int count = 0;
            for(int j = 0 ; j < len ; j++) {
                if(i != j) {
                    int numA = nums[i];
                    int numB = nums[j];
                    
                    if(numA > numB) count++;
                }
            }
            smaller[i] = count;
        }
        return smaller;
    }
}
