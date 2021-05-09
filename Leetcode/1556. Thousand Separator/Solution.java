/* https://leetcode.com/problems/thousand-separator/

Given an integer n, add a dot (".") as the thousands separator and return it in string format.

Example 1:
Input: n = 987
Output: "987"

Example 2:
Input: n = 1234
Output: "1.234"

Example 3:
Input: n = 123456789
Output: "123.456.789"

Example 4:
Input: n = 0
Output: "0"
 
Constraints:
0 <= n < 2^31
*/

class Solution {
    public String thousandSeparator(int n) {
        String str = Integer.toString(n);
        StringBuilder sb = new StringBuilder();

        for (int i = str.length(); i > 0; i -= 3) {
            if (sb.length() > 0) sb.insert(0, ".");
            sb.insert(0, str.substring(Math.max(0, i - 3), i));
        }
        return sb.toString();
    }
}

class Solution {
    public String thousandSeparator(int n) {
        String str = Integer.toString(n);
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        int len = str.length();
        for(int i = len-1 ; i >= 0 ; i--) {
            sb.insert(0, str.charAt(i));
            count++;
            if(count % 3 == 0 && i != 0) sb.insert(0, ".");
        }
        return sb.toString();
    }
}