/* https://leetcode.com/problems/relative-sort-array/

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

Example 1:
Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

Constraints:
arr1.length, arr2.length <= 1000
0 <= arr1[i], arr2[i] <= 1000
Each arr2[i] is distinct.
Each arr2[i] is in arr1.
*/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ret = new int[arr1.length]; // can use arr1 instead
        int[] count = new int[1001];
        int idx = 0;

        for(int num : arr1) {
            count[num]++;
        }

        for(int num : arr2) {
            while(count[num] > 0) { //add the elements in order that appear in arr2
                ret[idx] = num;
                idx++;
                count[num]--;
            }
        }

        for(int i = 0 ; i < 1001 ; i++) { //put rest that are not in arr2 in sorted order
            while(count[i] > 0) { // removed count in previous for loop
                ret[idx] = i;
                idx++;
                count[i]--;
            }
        }
        return ret;
    }
}
