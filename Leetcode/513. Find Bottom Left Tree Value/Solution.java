/* https://leetcode.com/problems/find-bottom-left-tree-value

Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3
Output:
1

Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7
Output:
7

Note: You may assume the tree (i.e., the given root node) is not NULL.
*/
class Solution {
    public int findBottomLeftValue(TreeNode root) {       
        Queue<TreeNode> q = new LinkedList<>();
        
        TreeNode node = root;
        q.add(root);
        while(!q.isEmpty()) { //level order traversal right to left per level last node will be left-most of last level
            node = q.poll();
            if(node.right != null) q.add(node.right);
            if(node.left != null) q.add(node.left);
        }
        return node.val;
    }
}
