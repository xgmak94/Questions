/* https://leetcode.com/problems/longest-consecutive-sequence/description/

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
            if(set.contains(n-1)) { //this number is part of a longer sequence
               continue; 
            }
            
            int i = 1;
            int streak = 1; //counting n
            while(set.contains(n+i)) {
                i++;
                streak++;
            }
            longest = Math.max(streak, longest);
        }
        return longest;
    }
}
