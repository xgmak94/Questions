/* https://leetcode.com/problems/number-of-segments-in-a-string/discuss/

Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

Please note that the string does not contain any non-printable characters.

Example:

Input: "Hello, my name is John"
Output: 5
*/

class Solution {
    public int countSegments(String s) {
        int length = s.length();
        
        int count = 0;
        for(int i = 0 ; i < length ; i++) {
            if(s.charAt(i) != ' ' && (i == length - 1 || s.charAt(i + 1) == ' ')) {
                count++;
            }
        }
        return count;
    }
}
