/* https://leetcode.com/problems/unique-number-of-occurrences/

Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true

*/

class Solution {
     public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        return count.size() == new HashSet<>(count.values()).size();
    }
}

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Set<Integer> counts = new HashSet<>();
        
        Arrays.sort(arr);
        
        int count = 1;
        int expectedCount = 0;
        for(int i = 1 ; i < arr.length ; i++) {
            if(arr[i] == arr[i-1])
                count++;
            else {
                counts.add(count);
                count = 1;
                expectedCount++;
            }
        }
        counts.add(count);
        expectedCount++;
        
        return counts.size() == expectedCount;
    }
}
