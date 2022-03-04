/* https://leetcode.com/problems/find-mode-in-binary-search-tree/

Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than or equal to the node's key.
The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
Both the left and right subtrees must also be binary search trees.
For example:
Given BST [1,null,2,2],
   1
    \
     2
    /
   2
return [2].

*/

public class Solution {
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        int maxCount = 0;
        q.add(root);
        while(!q.isEmpty()) {           
            TreeNode node = q.poll();
            if(node.left != null) q.add(node.left);
            if(node.right != null) q.add(node.right);
            
            map.put(node.val, map.getOrDefault(node.val, 0) + 1);

            if(map.get(node.val) > maxCount) {
                maxCount = map.get(node.val);
                list.clear();
                list.add(node.val);
            }
            else if(map.get(node.val) == maxCount) {
                list.add(node.val);
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
