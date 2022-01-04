/* https://leetcode.com/problems/insert-interval/description/

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
*/

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        
        int start = newInterval[0];
        int end = newInterval[1];
        for(int[] inter : intervals) {
            if(inter[1] < start) { //interval comes strictly before
                list.add(inter);
            }
            else if(inter[0] > end) { //interval comes strictly after
                list.add(new int[]{start, end});
                start = inter[0];
                end = inter[1];
            }
            else { //merge
                start = Math.min(start, inter[0]);
                end = Math.max(end, inter[1]);
            }
        }
        list.add(new int[]{start, end});
        return list.toArray(new int[list.size()][2]);
    }
}