/* https://leetcode.com/problems/find-mode-in-binary-search-tree/description/

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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] findMode(TreeNode root) {
        if(root == null)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        int maxCount = 0;
        q.add(root);
        while(!q.isEmpty()) {           
            TreeNode top = q.poll();
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
            
            map.put(top.val, map.getOrDefault(top.val, 0) + 1);

            if(map.get(top.val) > maxCount) {
                maxCount = map.get(top.val);
                list.clear();
            }
            
            if(map.get(top.val) == maxCount)
                list.add(top.val);
        }
        
        int[] ret = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++) 
            ret[i] = list.get(i);
        return ret;
    }
}
