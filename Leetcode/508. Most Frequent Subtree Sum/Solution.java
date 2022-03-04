/* https://leetcode.com/problems/most-frequent-subtree-sum/

Given the root of a tree, you are asked to find the most frequent subtree sum. 
The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). 
So what is the most frequent subtree sum value? 
If there is a tie, return all the values with the highest frequency in any order.

Examples 1
Input:
  5
 /  \
2   -3
return [2, -3, 4], since all the values happen only once, return all of them in any order.

Examples 2
Input:
  5
 /  \
2   -5
return [2], since 2 happens twice, however -5 only occur once.
*/

class Solution {
    int mostFrequent;
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        
        Map<Integer, Integer> map = new HashMap<>();
        mostFrequent = 0;
        
        postOrder(root, map);
        
        for(int key : map.keySet()) {
            if(map.get(key) == mostFrequent)
                list.add(key);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
    
    public int postOrder(TreeNode root, Map<Integer, Integer> map) {
        if(root == null)
            return 0;
        
        int left = postOrder(root.left, map);
        int right = postOrder(root.right, map);    

        int sum = left + right + root.val;  
        int count = map.getOrDefault(sum, 0) + 1;
        mostFrequent = Math.max(count, mostFrequent);

        map.put(sum, count);
        
        return sum;
    }
}
