/*

Given a Binary Search Tree, return the node with the maximum data.
Example:  
       4                                  
      / \                              
     2   8     
        / \                     
       5  10                  

Output ==> 10

*/

public TreeNode findMax(TreeNode root) {
    if(root == null || root.right == null){
        return root;
    }
    return findMax(root.right);         
}