/* https://leetcode.com/problems/top-k-frequent-elements/description/

Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].
*/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : nums)
            map.put(n, map.getOrDefault(n, 0) + 1);
        
        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                    return b.getValue() - a.getValue(); // key, value pairs character, count pairs
                }
            }
        );
        
        q.addAll(map.entrySet());
        for(int i = 0 ; i < k ; i++) {
            Map.Entry e = q.remove();
            List.add(e.getKey());
        }
        return list;
    }
}
