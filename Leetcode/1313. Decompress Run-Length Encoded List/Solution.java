/* https://leetcode.com/problems/decompress-run-length-encoded-list/

We are given a list nums of integers representing a list compressed with run-length encoding.

Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).  For each such pair, there are a elements with value b in the decompressed list.

Return the decompressed list.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [2,4,4,4]
Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
At the end the concatenation [2] + [4,4,4,4] is [2,4,4,4].

*/

class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2)
            for (int j = 0; j < nums[i]; ++j)
                ans.add(nums[i + 1]);
        return ans.stream().mapToInt(i -> i).toArray();
    }
}

class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0, j = 1; i < nums.length && j < nums.length ;  i += 2, j += 2) {
            int numTimes = nums[i];
            int val = nums[j];
            for(int n = 0 ; n < numTimes ; n++) {
                list.add(val);
            }
        }
        int[] ret = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
