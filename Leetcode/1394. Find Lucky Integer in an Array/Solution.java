import java.util.Map;

/* https://leetcode.com/problems/find-lucky-integer-in-an-array/

Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.

Return a lucky integer in the array. 
If there are multiple lucky integers return the largest of them. 
If there is no lucky integer return -1.

Example 1:
Input: arr = [2,2,3,4]
Output: 2
Explanation: The only lucky number in the array is 2 because frequency[2] == 2.

Example 2:
Input: arr = [1,2,2,3,3,3]
Output: 3
Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.

Example 3:
Input: arr = [2,2,2,3,3]
Output: -1
Explanation: There are no lucky numbers in the array.

Example 4:
Input: arr = [5]
Output: -1

Example 5:
Input: arr = [7,7,7,7,7,7,7]
Output: 7
*/

class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int maxLucky = -1;
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getKey() == e.getValue()) {
                maxLucky = Math.max(maxLucky, e.getKey());
            }
        }
        return maxLucky;
    }
}

class Solution {
    public int findLucky(int[] arr) {
        Arrays.sort(arr);
        for(int i = arr.length - 1 ; i >= 0 ; ) {
            int count = 1;
            int curr = arr[i];
            while(i-count >= 0 && arr[i-count] == curr) {
                count++;
            }
            if(count == curr) return curr;
            i -= count;
        }
        return -1;
    }
}
