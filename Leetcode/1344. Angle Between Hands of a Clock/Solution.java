/* https://leetcode.com/problems/angle-between-hands-of-a-clock/

Given two numbers, hour and minutes. Return the smaller angle (in sexagesimal units) formed between the hour and the minute hand.

Example 1:
Input: hour = 12, minutes = 30
Output: 165

Example 2:
Input: hour = 3, minutes = 30
Output: 75

Example 3:
Input: hour = 3, minutes = 15
Output: 7.5

Example 4:
Input: hour = 4, minutes = 50
Output: 155

Example 5:
Input: hour = 12, minutes = 0
Output: 0

*/

class Solution {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 180/30;
        double hourAngle = (hour * 180/6) + ((double)minutes/60 * 180/6);
        double diff = Math.abs(minuteAngle - hourAngle);
        
        if(diff > 180) return 360.0 - diff;
        else return diff;
    }
}
