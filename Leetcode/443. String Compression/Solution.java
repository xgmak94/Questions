/* https://leetcode.com/problems/string-compression/description/

Given an array of characters, compress it in-place.
The length after compression must always be smaller than or equal to the original array.
Every element of the array should be a character (not int) of length 1.
After you are done modifying the input array in-place, return the new length of the array.

Follow up:
Could you solve it using only O(1) extra space?

Example 1:
Input:
["a","a","b","b","c","c","c"]
Output:
Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation:
"aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".

Example 2:
Input:
["a"]
Output:
Return 1, and the first 1 characters of the input array should be: ["a"]
Explanation:
Nothing is replaced.

Example 3:
Input:
["a","b","b","b","b","b","b","b","b","b","b","b","b"]
Output:
Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].

Explanation:
Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
Notice each digit has it's own entry in the array.
*/

class Solution {
    public int compress(char[] chars) {
        int indexWrite = 0;
        int index = 0;

        while(index < chars.length) {
            char curr = chars[index];
            int count = 0;
            while(index < chars.length && chars[index] == curr) {
                index++;
                count++;
            }
            chars[indexWrite++] = curr; //write the char
            if(count != 1) {
                for(char c : Integer.toString(count).toCharArray()) { //write the number
                    chars[indexWrite++] = c;
                }
            }
        }
        return indexWrite;
    }
}

// doesnt work
class Solution {
    public int compress(char[] chars) {
        if(chars.length <= 1)
            return chars.length;
        
        int length = 0;
        int idx = 0;    
        
        for(int i = 0 ; i < chars.length - 1 ; i++) {
            int count = 1;
            char curr = chars[i];
            
            while(i < chars.length - 1 && chars[i] == chars[i+1]) {
                count++;
                i++;
            }
            
            chars[idx] = curr;
            idx++;
            length++;
            
            if(count != 1) {
                char[] arr = String.valueOf(count).toCharArray();
                for(int j = 0 ; j < arr.length ; j++) {
                    chars[idx] = arr[j];
                    idx++;
                    length++;
                }
            }
        }
        if(chars[idx] != chars[idx-1])
            chars[idx] = chars[chars.length-1];
        
        return idx;
    }
}

