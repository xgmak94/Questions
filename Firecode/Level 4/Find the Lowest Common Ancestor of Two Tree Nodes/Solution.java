/*

Given a binary tree and two tree nodes, write a method to find
LCA
(Lowest Common Ancestor) of the two nodes.
Example:  
       1              
      / \            
     2   3   
    / \ / \       
   4  5 6  7    
    ==> 
LCA
 of 6 and 4 is 1,    
    
LCA
 of 4 and 5 is 2. 

*/

public TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {                   
        TreeNode left, right = null;
        if(root == null || a == null || b == null) return null;
        if(root == a || root == b) return root;
        left = findLCA(root.left, a, b);
        right = findLCA(root.right, a, b);
        if(left != null && right != null) {
            return root;
        } else {
            return (left != null ? left : right);
        }
    } 