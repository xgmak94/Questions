/* https://leetcode.com/problems/four-divisors/

Given an integer array nums, return the sum of divisors of the integers in that array that have exactly four divisors.

If there is no such integer in the array, return 0.

Example 1:
Input: nums = [21,4,7]
Output: 32
Explanation:
21 has 4 divisors: 1, 3, 7, 21
4 has 3 divisors: 1, 2, 4
7 has 2 divisors: 1, 7
The answer is the sum of divisors of 21 only.
 
Constraints:
1 <= nums.length <= 10^4
1 <= nums[i] <= 10^5
*/

class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            List<Integer> list = divisors(num);
            if(list.size() == 4) {
                for(int n : list) {
                    sum += n;
                }
            }
        }
        return sum;
    }
    
    public List<Integer> divisors(int num) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i*i <= num ; i++) {
            if(num % i == 0) {
                list.add(i);
                if(num/i != i) list.add(num/i);
            }
        }
        return list;
    }
}
