/* https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/

Given an integer array sorted in non-decreasing order, there is exactly one integer in the array that occurs more than 25% of the time.

Return that integer.

Example 1:
Input: arr = [1,2,2,6,6,6,6,7,10]
Output: 6
*/
class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        int t = n/4;

        for(int i = 0 ; i < n-t ; i++) {
            if(arr[i] == arr[i + t]) { //element will appear at both locations
                return arr[i];
            }
        }
        return -1;
    }
}

class Solution {
    public int findSpecialInteger(int[] arr) {
        int count = 1;
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i] == arr[i-1]) {
                count++;
                if(count == arr.length/4) {
                    return arr[i];
                }
            }
            else {
                count = 1;
            }
        }
        return arr[arr.length-1];
    }
}
