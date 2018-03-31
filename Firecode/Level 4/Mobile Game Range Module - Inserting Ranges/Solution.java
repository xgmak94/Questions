/*

A Range Module is a module that tracks ranges of numbers. Range modules are used extensively when designing scalable online game maps with millions of players. Your task is to write a method - insertRange that takes in an ArrayList of sorted, non-overlapping integer Interval s (aka ranges) and a new Interval - insert, and returns an ArrayList of sorted Interval s where insert has been added to the ArrayList in the correct spot and the required overlapping ranges have been merged. The Interval class is available by clicking Use Me. Target a time complexity of O(n).

Note: 
a) [1,3] represents an interval that includes 1, 2 and 3.
b) Intervals should be sorted based on the value of start
c) The words Range and Interval are used interchangeably

Examples: 
Inputs: [ [1,3], [7,10] ] & [2,6], Output: [ [1,6], [7,10] ]

*/

public static ArrayList<Interval> insertRange(ArrayList<Interval> intervalsList, Interval insert) {
    ArrayList<Interval> out = new ArrayList<>();
    for(Interval i: intervalsList){
        if(i.end < insert.start) {
            out.add(i);
        }
        else if(i.start > insert.end) {
            out.add(insert);
            insert = i;
        }
        else if(i.start <= insert.end || i.end >= insert.start){
            int newStart = Math.min(i.start, insert.start);
            int newEnd = Math.max(i.end, insert.end);
            insert = new Interval(newStart, newEnd);
        }
    }
    out.add(insert);
    return out;
}