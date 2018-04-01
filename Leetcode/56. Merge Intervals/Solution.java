/* https://leetcode.com/problems/merge-intervals/
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
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
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<>();
        
        if(intervals.size() < 2) {
            return intervals;
        }
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval interval : intervals) {
            if(interval.start <= end) {
                end = Math.max(end, interval.end);
            }
            else {
                ret.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        ret.add(new Interval(start, end));
        return ret;
    }
}
