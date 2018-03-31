/*
Given a binary tree, write a recursive method to return the maximum element.
Examples:  
     1                
    / \             
   2   3     ==>  7
  / \ / \           
 4  5 6  7 
*/

public int findMax(TreeNode root) {                         
    if (root == null) 
    	return Integer.MIN_VALUE;
    
    int leafMax = Math.max(findMax(root.left), findMax(root.right));

    return Math.max(root.data, leafMax);
}