/* https://leetcode.com/problems/longest-consecutive-sequence/

Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;
        
        for(int n : nums) {
            set.add(n);
        }
        
        for(int n : nums) {
            int left = n-1;
            int right = n+1;
            
            while(set.remove(left)) {
                left--;
            }
            while(set.remove(right)) {
                right++;
            }
            longest = Math.max(right-left-1, longest);
            
            if(set.isEmpty()) break;
        }
        return longest;
    }
}
