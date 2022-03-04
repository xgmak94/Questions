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

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;  
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            if(node.left != null) {
                if(node.left.left == null && node.left.right == null) { //if leaf
                    sum += node.left.val;
                }
                else { //not a leaf add to q
                    q.add(node.left);
                }
            }
            if(node.right != null) {
                if(node.right.left != null || node.right.right != null) {
                    q.add(node.right);
                }
            }
        }
        return sum;
    }
}

class Solution {
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
