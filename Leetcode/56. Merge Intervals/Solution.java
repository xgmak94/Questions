/* https://leetcode.com/problems/merge-intervals/
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) return intervals;
        
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        
        int currStart = intervals[0][0];
        int currEnd = intervals[0][1];
        for(int[] interval : intervals) {
            if(interval[0] <= currEnd) { //merge, previous interval overlaps with new interval
                currEnd = Math.max(currEnd, interval[1]);
            }
            else { //intervals do not overlap, add previous interval
                list.add(new int[]{currStart, currEnd});
                currStart = interval[0];
                currEnd = interval[1];
            }
        }
        list.add(new int[]{currStart, currEnd}); //add last interval
        
        return list.toArray(new int[list.size()][2]);
    }
}