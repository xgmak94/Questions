/* https://leetcode.com/problems/reverse-string/de

Write a function that takes a string as input and returns the string reversed.

Example:
Given s = "hello", return "olleh".

*/

class Solution {
    public String reverseString(String s) {
        StringBuilder string = new StringBuilder(s);
        return string.reverse().toString();
    }
}