/* https://leetcode.com/problems/degree-of-an-array/description/

Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.

Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6
*/

class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int degree = 0;
        int minLength = 0;

        for(int i = 0 ; i < nums.length ; i++) {
            int num = nums[i];
            count.put(nums[i], count.getOrDefault(num, 0) + 1);
            firstIndex.putIfAbsent(num, i);

            if(count.get(num) > degree) {
                degree = count.get(num);
                minLength = i - firstIndex.get(num) + 1;
            }
            else if(count.get(num) == degree){
                minLength = Math.min(minLength, i - firstIndex.get(num) + 1);
            }
        }
        return minLength;
    }
}

class Solution {
    public int findShortestSubArray(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int degree = 0;
        for(int i = 0 ; i < nums.length ; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            degree = Math.max(degree, map.get(nums[i]));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int count = entry.getValue();
            if(count == degree) {
                list.add(num);
            }
        }
        
        int minLength = Integer.MAX_VALUE;
        //for every number in list get the first index and last index then get the min of those
        for(int n : list) {
            int first = firstIndexOf(nums, n);
            int last = lastIndexOf(nums, n);
            
            minLength = Math.min(minLength, last - first + 1);
        }
        return minLength;
    }
    
    public int firstIndexOf(int[] nums, int n) {
        for(int i = 0 ; i < nums.length ; i++)
            if(nums[i] == n) {
                return i;
            }
        return -1;
    }
    
    public int lastIndexOf(int[] nums, int n) {
        int idx = -1;
        for(int i = 0 ; i < nums.length ; i++)
            if(nums[i] == n) {
                idx = i;
            }
        return idx;
    }
}
