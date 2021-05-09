/* https://leetcode.com/problems/reformat-date/

Given a date string in the form Day Month Year, where:

Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
Year is in the range [1900, 2100].
Convert the date string to the format YYYY-MM-DD, where:

YYYY denotes the 4 digit year.
MM denotes the 2 digit month.
DD denotes the 2 digit day.
 

Example 1:

Input: date = "20th Oct 2052"
Output: "2052-10-20"
Example 2:

Input: date = "6th Jun 1933"
Output: "1933-06-06"
Example 3:

Input: date = "26th May 1960"
Output: "1960-05-26"
 

Constraints:

The given dates are guaranteed to be valid, so no error handling is necessary.
*/

class Solution {
    public String reformatDate(String date) {
        String[] split = date.split(" ");
        String day = split[0];
        String month = split[1];
        String year = split[2];
        
        String output = String.format("%s-%s-%s", year, getMonth(month), stringDate(day));
        return output;
    }
    
    public String stringDate(String day) {
        if(day.length() == 3) { //1-9
            return "0" + day.charAt(0);
        else 
        	return day.substring(0, 2);
    }
    
    public String getMonth(String month) {
        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i = 0 ; i < months.length ; i++) {
            if(month.equals(months[i]))  {
                if(i < 10) 
                	return "0" + Integer.toString(i);
                else 
                	return Integer.toString(i);
            }
        }
        return "";
    }
}
