/* https://leetcode.com/problems/student-attendance-record-i/description/

You are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
*/
class Solution {
    public boolean checkRecord(String s) {
        int length = s.length();
        if(length < 2)
            return true;
        
        if(s.indexOf('A') != s.lastIndexOf('A') || s.contains("LLL"))
            return false;
        
        return true;
    }
}

class Solution {
    public boolean checkRecord(String s) {
        int length = s.length();
        if(length < 2)
            return true;
        
        int countA = 0;
        
        for(int i = 0 ; i < length ; i++) {
            char c = s.charAt(i);
            if(c == 'A') {
                countA++;
                if(countA >= 2)
                    return false;
            }
            if(c == 'L') {
                if(i + 1 < length && i + 2 < length && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L')
                    return false;
            }
        }
        return true;
    }
}
