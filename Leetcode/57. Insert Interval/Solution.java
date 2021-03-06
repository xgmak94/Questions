/* https://leetcode.com/problems/insert-interval/description/

Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                if(i1.start != i2.start)
                    return i1.start - i2.start;
                else
                    return i1.end - i2.end;
            }
        });
        
        int start = newInterval.start;
        int end = newInterval.end;
        
        for(Interval i : intervals) {
            if(i.end < start) {
                ret.add(i);
            }
            else if(i.start > end) {
                ret.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
            else if(i.end >= start || i.start <= end){
                start = Math.min(start, i.start);
                end = Math.max(end, i.end);
            }
        }
        ret.add(new Interval(start, end));
        return ret;
    }
}
