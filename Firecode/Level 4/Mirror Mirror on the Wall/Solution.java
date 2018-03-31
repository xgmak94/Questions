/*
Write a method to check if the two given binary trees are the mirror images of each other. Return true if they are, false otherwise. What's a binary tree's mirror image? Hold it by the root and rotate all other nodes by 180 degrees!
Example:
       1              1
      / \            / \
     2   3    ==    3   2
    / \ / \        / \ / \
   4  5 6  7      7  6 5  4
*/

public boolean isMirror(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null)
        return true;
    else if(root1 == null || root2 == null)
        return false;
    else if(root1.data != root2.data)
        return false;
    else
        return isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left);
}