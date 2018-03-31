/*
Given aBinary Search Tree, return the node with the minimum data.
Example:  
       4                                  
      / \                              
     2   8     
        / \                     
       5  10                  

Output ==> 2
*/

public TreeNode findMin(TreeNode root) {
    if(root == null || root.left == null)
        return root;
    return findMin(root.left);
}