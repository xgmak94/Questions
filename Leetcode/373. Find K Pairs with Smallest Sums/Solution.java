/* https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
Define a pair (u,v) which consists of one element from the first array and one element from the second array.
Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [1,1],[1,1]
Explanation: The first 2 pairs are returned from the sequence: 
             [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]

Example 3:
Input: nums1 = [1,2], nums2 = [3], k = 3
Output: [1,3],[2,3]
Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();
        if(nums1.length == 0 || nums2.length == 0 || k <= 0) return list;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]+a[1] - b[0]-b[1]);
        
        for(int i = 0 ; i < nums1.length && i < k ; i++) { //only need first k, arrys sorted
            pq.offer(new int[]{nums1[i], nums2[0], 0}); //nums1 val, nums2 first val, index of nums2 val
        }
        
        while(list.size() < k && pq.size() > 0) {
            List<Integer> small = new ArrayList<>();
            int[] pair = pq.poll();
            small.add(pair[0]); small.add(pair[1]);
            list.add(small);

            int idx = pair[2];
            if(pair[2]+1 < nums2.length) { //only need to check element in second array if prev was in kSmallest
                pq.offer(new int[]{pair[0], nums2[idx+1], idx+1}); // add next element with incremented idx in num2
            }
        }
        return list;
    }
}
