/* https://leetcode.com/problems/cousins-in-binary-tree/

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
Input: root = [1,2,3,4], x = 4, y = 3
Output: false

Example 2:
Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true

Example 3:
Input: root = [1,2,3,null,4], x = 2, y = 3
Output: false
*/

class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        if(getDepth(root, x, 0) == getDepth(root, y, 0) && 
            getParent(root, x, null) != getParent(root, y, null)) {
            return true;
        }
        else {
            return false; //depth same parent not same
        }
    }

    public TreeNode getParent(TreeNode root, int n, TreeNode parent){
        if(root == null) return null;
        
        if(root.val == n) {
            return parent;
        }
        else {
            TreeNode left = getParent(root.left, n, root);
            TreeNode right = getParent(root.right, n, root);
            
            if(left == null) return right;
            else return left;
        }
    }

    public int getDepth(TreeNode root, int n, int depth) {
        if(root == null) return 0;

        if(root.val == n) {
            return depth;
        }
        else {
            return getDepth(root.left, n, depth+1) + getDepth(root.right, n, depth+1);
        }
    }
}

class Solution {
    TreeNode xParent = null;
    TreeNode yParent = null;
    int xDepth = -1, yDepth = -1;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        getDepthAndParent(root, x, y, 0, null);
        return ((xDepth == yDepth) && (xParent != yParent)) ? true: false; //depth same parent not same
    }
    
    public void getDepthAndParent(TreeNode root, int x, int y, int depth, TreeNode parent){
        if(root == null) return;
        
        if(root.val == x){
            xParent = parent;
            xDepth = depth;
        }else if(root.val == y){
            yParent = parent;
            yDepth = depth;
        }
        getDepthAndParent(root.left, x, y, depth + 1, root);
        getDepthAndParent(root.right, x, y, depth + 1, root);
    }
}
