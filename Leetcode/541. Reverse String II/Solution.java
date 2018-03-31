/* https://leetcode.com/problems/reverse-string-ii/description/

Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and left the other as original.
Example:
Input: s = "abcdefg", k = 2
Output: "bacdfeg"
Restrictions:
The string consists of lower English letters only.
Length of the given string and k will in the range [1, 10000]

*/

class Solution {
    public String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        
        int length = arr.length;
        int i = 0;
        
        while(i < length) {
            int j = Math.min(i + k - 1, length - 1);
            reverse(arr, i, j);
            i = i + 2*k;
        }
        return String.valueOf(arr);
    }
    
    
    public void reverse(char[] string, int left, int right) {
        while(left < right) {
            char temp = string[left];
            string[left] = string[right];
            string[right] = temp;
            
            left++;
            right--;
        }
    }
}
