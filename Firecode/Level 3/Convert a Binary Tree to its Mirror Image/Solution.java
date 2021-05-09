/*

Write a function to convert a binary tree into its mirror image and return the root node of the mirrored tree.
Example:  
       1              
      / \            
     2   3       
    / \ / \        
   4  5 6  7          

       |
       V
  Mirror Form
       1
      / \
     3   2
    / \ / \
   7  6 5  4 

Output = Level Order:[1, 3, 2, 7, 6, 5, 4]

*/

public TreeNode mirror(TreeNode root) {
    if(root == null)
        return null;
        
    TreeNode temp = root.left; 
    root.left = mirror(root.right);
    root.right = mirror(temp);
    
    return root;
}