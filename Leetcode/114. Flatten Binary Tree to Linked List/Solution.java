/* https://leetcode.com/problems/flatten-binary-tree-to-linked-list/

Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
*/

class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        
        preOrder(q, root);
        
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            curr.left = null;
            curr.right = q.peek();
        }
    }
    
    public void preOrder(Queue<TreeNode> q, TreeNode root) {
        q.add(root);
        if(root.left != null) preOrder(q, root.left);
        if(root.right != null) preOrder(q, root.right);
    }
}
