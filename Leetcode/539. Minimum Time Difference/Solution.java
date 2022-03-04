/* https://leetcode.com/problems/minimum-time-difference/

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.

Example 1:
Input: ["23:59","00:00"]
Output: 1

Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.
*/

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] minutes = new boolean[1440]; // 24*60, store all minutes
        Arrays.fill(minutes, false);
        for(String time : timePoints) {
            String[] t = time.split(":");
            int hour = Integer.parseInt(t[0]);
            int min = Integer.parseInt(t[1]);
            
            if(minutes[hour*60 + min] == true) return 0; //this time already appeared
            minutes[hour*60 + min] = true;
        }
        
        int prev = Integer.MAX_VALUE, minDiff = Integer.MAX_VALUE;
        int first = Integer.MAX_VALUE, last = Integer.MIN_VALUE;
        for(int i = 0 ; i < minutes.length ; i++) {
            if(minutes[i] == true) {
            	if(prev != Integer.MAX_VALUE) minDiff = Math.min(i-prev, minDiff); // if this is not the first elem

            	prev = i;
                first = Math.min(i, first);
                last = Math.max(i, last);
            }
        }
        minDiff = Math.min(first-last+1440, minDiff); //time between largest time and smallest time
        return minDiff;
    }
}
