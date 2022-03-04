/* https://leetcode.com/problems/minimum-operations-to-make-the-array-alternating/

You are given a 0-indexed array nums consisting of n positive integers.

The array nums is called alternating if:

nums[i - 2] == nums[i], where 2 <= i <= n - 1.
nums[i - 1] != nums[i], where 1 <= i <= n - 1.
In one operation, you can choose an index i and change nums[i] into any positive integer.

Return the minimum number of operations required to make the array alternating.

Example 1:
Input: nums = [3,1,3,2,4,3]
Output: 3
Explanation:
One way to make the array alternating is by converting it to [3,1,3,1,3,1].
The number of operations required in this case is 3.
It can be proven that it is not possible to make the array alternating in less than 3 operations. 

Example 2:
Input: nums = [1,2,2,2,2]
Output: 2
Explanation:
One way to make the array alternating is by converting it to [1,2,1,2,1].
The number of operations required in this case is 2.
Note that the array cannot be converted to [2,2,2,2,2] because in this case nums[0] == nums[1] which violates the conditions of an alternating array.

Constraints:
1 <= nums.length <= 105
1 <= nums[i] <= 105
*/

class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> odds = new HashMap<>();
        Map<Integer, Integer> evens = new HashMap<>();
        
        for(int i = 0 ; i < nums.length ; i++) {
            if(i % 2 == 1) {
                odds.put(nums[i], odds.getOrDefault(nums[i], 0) + 1);
            }
            else {
                evens.put(nums[i], evens.getOrDefault(nums[i], 0) + 1);
            }
        }

        Map.Entry<Integer, Integer> firstOdd = null;
        Map.Entry<Integer, Integer> secondOdd = null;
        for(Map.Entry<Integer, Integer> entry : odds.entrySet()) {
            if(firstOdd == null || entry.getValue() >= firstOdd.getValue()) {
                secondOdd = firstOdd;
                firstOdd = entry;
            }
            else if(secondOdd == null || entry.getValue() > secondOdd.getValue()) {
                secondOdd = entry;
            }
        }

        Map.Entry<Integer, Integer> firstEven = null;
        Map.Entry<Integer, Integer> secondEven = null;
        for(Map.Entry<Integer, Integer> entry : evens.entrySet()) {
            if(firstEven == null || entry.getValue() >= firstEven.getValue()) {
                secondEven = firstEven;
                firstEven = entry;
            }
            else if(secondEven == null || entry.getValue() > secondEven.getValue()) {
                secondEven = entry;
            }
        }
        if(firstOdd != null && firstEven != null && firstOdd.getKey() != firstEven.getKey()) { //values are not equal so we need to change all others
            return nums.length - firstOdd.getValue() - firstEven.getValue();
        }
        else { //nums are equal so we must use the second highest for either odd or even index
            int even = nums.length; //using second even freq
            if(firstOdd != null) even -= firstOdd.getValue();
            if(secondEven != null) even -= secondEven.getValue();
            
            int odd = nums.length; //using second odd freq
            if(secondOdd != null) odd -= secondOdd.getValue();
            if(firstEven != null) odd -= firstEven.getValue();
            
            return Math.min(even, odd);
        }
    }
}
