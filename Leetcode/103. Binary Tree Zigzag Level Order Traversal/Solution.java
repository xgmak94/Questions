/* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]

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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        
        if(root == null)return list;
        
        int currLevel = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int levelSize = q.size();
            for(int i = 0 ; i < levelSize ; i++) {
                TreeNode curr = q.remove();
                level.add(curr.val);
            
                if(curr.left != null)  q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            if(currLevel++ % 2 == 1) // we reverse every other level
                Collections.reverse(level);

            list.add(level);
            level = new ArrayList<>();
        }
        return list;
    }
}
