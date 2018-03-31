/* https://leetcode.com/problems/balanced-binary-tree/description/

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        int left = height(root.left);
        int right = height(root.right);
        
        if(Math.abs(left - right) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        else
            return false;
    }
    
    public int height(TreeNode root) {
        if(root == null)
            return 0;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
