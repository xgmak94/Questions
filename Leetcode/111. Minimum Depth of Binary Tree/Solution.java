/* https://leetcode.com/problems/minimum-depth-of-binary-tree/description/

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        else {
            int left = minDepth(root.left);
            int right = minDepth(root.right);
            
            if(left == 0 || right == 0)
                return 1 + left + right;
            else
                return 1 + Math.min(left, right);
        }
    }
}
