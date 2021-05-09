/*
Write a function to find the total number of leaf nodes in a binary tree. 
A node is described as a leaf node if it doesn't have any children. 
If there are no leaf nodes, return 0.

Example:  
       1
      / \
     2   3     
    / \ / \
   4  5 6  7
  / \
 8   9     
==> no. of leaves = 5

*/

public int numberOfLeaves(TreeNode root) { 
    if(root == null)
        return 0;
	else if(root.left == null && root.right == null)
        return 1;
	else
		return numberOfLeaves(root.left) + numberOfLeaves(root.right);
}