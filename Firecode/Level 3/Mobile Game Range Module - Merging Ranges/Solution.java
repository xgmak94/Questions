/*
A Range Module is a module that tracks ranges of numbers. Range modules are used extensively when designing scalable online game maps with millions of players. Your task is to write a method - mergeIntervals that takes in an ArrayList of integer Interval s (aka ranges), and returns an ArrayList of sorted Interval s where all overlapping intervals have been merged. The Interval class is available by clicking Use Me. 

Note: 
a) [1,3] represents an interval that includes 1, 2 and 3.
b) Intervals should be sorted based on the value of start

Examples: 
Input: [ [1,3], [2,5] ], Output: [ [1,5] ]
Input: [ [3,5], [1,2] ], Output: [ [1,2], [3,5] ]
*/

public static ArrayList<Interval> mergeIntervals(ArrayList<Interval> intervalsList) {
    if (intervalsList == null || intervalsList.size() < 2) {
        return intervalsList;
    } else {
        ArrayList<Interval> out = new ArrayList<>();
        Collections.sort(intervalsList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });

        Interval prev = intervalsList.get(0);
        for (int i = 1; i < intervalsList.size(); i++) {
            Interval cur = intervalsList.get(i);
            // Merge if not overlapping
            if (cur.start <= prev.end) {
                prev = new Interval(prev.start, Math.max(cur.end, prev.end));
            } else {
                // Otherwise add and update curInterval
                out.add(prev);
                prev = cur;
            }
        }
        out.add(prev);
        return out;
    }
}