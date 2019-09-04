/* https://leetcode.com/problems/relative-sort-array/

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.

Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

 

Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

*/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] relativeSort = new int[arr1.length];
        int idx = 0;
        
        Map<Integer, Integer> map = new TreeMap<>();
        
        for(int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        //get entrys that were in arr 2
        for(int n : arr2) {
            int count = map.get(n);
            map.remove(n);
            
            for(int i = 0 ; i < count ; i++)
                relativeSort[idx++] = n;
        }
        
        //get rest of entrys sorted by treemap
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            for(int i = 0 ; i < entry.getValue() ; i++)
                relativeSort[idx++] = entry.getKey();
        }
            
        return relativeSort;
    }
}
