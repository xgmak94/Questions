/* https://leetcode.com/problems/diagonal-traverse-ii/

Given a list of lists of integers, nums, return all elements of nums in diagonal order as shown in the below images.

Example 1:
Input: nums = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,4,2,7,5,3,8,6,9]

Example 2:
Input: nums = [[1,2,3,4,5],[6,7],[8],[9,10,11],[12,13,14,15,16]]
Output: [1,6,2,8,7,3,9,4,12,10,5,13,11,14,15,16]

Example 3:
Input: nums = [[1,2,3],[4],[5,6,7],[8],[9,10,11]]
Output: [1,4,2,5,3,8,6,9,7,10,11]

Example 4:
Input: nums = [[1,2,3,4,5,6]]
Output: [1,2,3,4,5,6]

Constraints:
1 <= nums.length <= 10^5
1 <= nums[i].length <= 10^5
1 <= nums[i][j] <= 10^9
There at most 10^5 elements in nums.
*/

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int maxKey = 0;
        
        for(int i = 0 ; i < nums.size() ; i++) {
            for(int j = 0 ; j < nums.get(i).size() ; j++) {
            	int key = i+j;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(0, nums.get(i).get(j)); //add it to front of list
                
                maxKey = Math.max(maxKey, key);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <= maxKey ; i++) {
            list.addAll(map.get(i));
        }
        
        int[] ret = new int[list.size()];
        for(int i = 0 ; i <list.size() ; i++) {
            ret[i] = list.get(i);
        }
        return ret;
    }
}
