/*
Given a BST, write a function to return its diameter. The diameter of a Binary Tree is defined as the "Number of nodes on the longest path between two leaf nodes".

Example:  
      20                                  
    /     \                              
   15     30 
  /  \      \  diameter ==> 7                    
 14  18     35
    /  \    /
   17  19  32


*/

public int diameter(TreeNode root) {
    if (root == null)
        return 0;

    int diameter = findHeight(root.left) + findHeight(root.right) + 1;
    return Math.max(diameter, Math.max(diameter(root.left), diameter(root.right)));
}

public int findHeight(TreeNode root) {
        /* base case tree is empty */
        if(root == null) return 0;
        /* If tree is not empty then height = 1 + max of left
            height and right heights */
        return 1 + Math.max(findHeight(root.left), findHeight(root.right));    
}   