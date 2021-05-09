/* https://leetcode.com/problems/binary-tree-level-order-traversal

Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/* 
Make use of a queue to do a breadth first traversal.
Then we use a series of lists to represent each level in the tree
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            int numInLevel = q.size();
            
            for(int i = 0 ; i < numInLevel ; i++) {
                TreeNode curr = q.remove();
                level.add(curr.val);

                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            list.add(level);
        }
        return list;
    }
}
