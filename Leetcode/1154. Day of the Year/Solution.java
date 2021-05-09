/* https://leetcode.com/problems/day-of-the-year/

Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

Example 1:
Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.

Example 2:
Input: date = "2019-02-10"
Output: 41

Example 3:
Input: date = "2003-03-01"
Output: 60

Example 4:
Input: date = "2004-03-01"
Output: 61
*/

class Solution {
    public int dayOfYear(String S) {
        int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        
        String[] s = S.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int date = Integer.parseInt(s[2]);
        
        if(checkLeap(year)) monthDays[1]++;
        for(int i = 0 ; i < month - 1; i++) {
            date += monthDays[i];
        }
        return date;
    }
    
    public boolean checkLeap(int year) {
        if(year % 400 == 0) return true;
        else if(year % 100 == 0) return false;
        else if(year % 4 == 0) return true;
        else return false;
    }
}
