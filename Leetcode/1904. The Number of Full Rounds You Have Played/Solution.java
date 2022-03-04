/* https://leetcode.com/problems/the-number-of-full-rounds-you-have-played/

A new online video game has been released, and in this video game, there are 15-minute rounds scheduled every quarter-hour period. This means that at HH:00, HH:15, HH:30 and HH:45, a new round starts, where HH represents an integer number from 00 to 23. A 24-hour clock is used, so the earliest time in the day is 00:00 and the latest is 23:59.

Given two strings startTime and finishTime in the format "HH:MM" representing the exact time you started and finished playing the game, respectively, calculate the number of full rounds that you played during your game session.

For example, if startTime = "05:20" and finishTime = "05:59" this means you played only one full round from 05:30 to 05:45. You did not play the full round from 05:15 to 05:30 because you started after the round began, and you did not play the full round from 05:45 to 06:00 because you stopped before the round ended.
If finishTime is earlier than startTime, this means you have played overnight (from startTime to the midnight and from midnight to finishTime).

Return the number of full rounds that you have played if you had started playing at startTime and finished at finishTime.

Example 1:
Input: startTime = "12:01", finishTime = "12:44"
Output: 1
Explanation: You played one full round from 12:15 to 12:30.
You did not play the full round from 12:00 to 12:15 because you started playing at 12:01 after it began.
You did not play the full round from 12:30 to 12:45 because you stopped playing at 12:44 before it ended.

Example 2:
Input: startTime = "20:00", finishTime = "06:00"
Output: 40
Explanation: You played 16 full rounds from 20:00 to 00:00 and 24 full rounds from 00:00 to 06:00.
16 + 24 = 40.

Example 3:
Input: startTime = "00:00", finishTime = "23:59"
Output: 95
Explanation: You played 4 full rounds each hour except for the last hour where you played 3 full rounds.

Constraints:
startTime and finishTime are in the format HH:MM.
00 <= HH <= 23
00 <= MM <= 59
startTime and finishTime are not equal.
*/

class Solution {
    public int numberOfRounds(String startTime, String finishTime) {
        int start = timeMinutes(startTime);
        int fin = timeMinutes(finishTime);
        
        if(start > fin) fin += 60*24;
        
        //round startTime to NEXT 15, round finishTime to PREV 15
        if(start % 15 != 0) start += 15 - (start % 15);
        fin -= fin % 15;
        
        return (fin - start) / 15;
    }
    
    public int timeMinutes(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
    }
}
