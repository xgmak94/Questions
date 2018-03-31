/* https://leetcode.com/problems/sum-of-left-leaves/description/

Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.

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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null)
            return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;  
        while(!q.isEmpty()) {
            TreeNode top = q.poll();
            if(top.left != null) {
                if(top.left.left == null && top.left.right == null) {
                    sum += top.left.val;
                }
                else {
                    q.add(top.left);
                }
            }
            if(top.right != null) {
                if(top.right.left != null || top.right.right != null) {
                    q.add(top.right);
                }
            }
        }
        return sum;
    }
}

public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        if(root == null)
            return 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            }
            else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        sum += sumOfLeftLeaves(root.right);
        
        return sum;
    }
}
