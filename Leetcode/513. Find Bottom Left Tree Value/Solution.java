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
    public int findBottomLeftValue(TreeNode root) {       
        Queue<TreeNode> q = new LinkedList<>();
        
        q.add(root);
        
        TreeNode curr = root;
        
        while(!q.isEmpty()) { //level order traversal right to left per level
            curr = q.remove();
            if(curr.right != null)
                q.add(curr.right);
            if(curr.left != null)
                q.add(curr.left);
        }
        return curr.val;
    }
}
