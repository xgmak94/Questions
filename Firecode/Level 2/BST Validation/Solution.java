/*
Given the root node of a Binary Tree, determine if it is a Binary Search Tree.

Examples:

          20
        /   \
      15    30
     /  \
    14  18     

    output ==> true

          20
         /   \
       30    15 
      /  \                           
     14  18     

   output ==> false

*/

public static boolean validateBST(TreeNode root) {
    return validateBST(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public static boolean validateBST(TreeNode root, int min, int max) {
    if (root == null) {
            return true;
    }
    if (root.data <= min || root.data >= max) {
            return false;
    }
    // left subtree must be < root.val && right subtree must be > root.val
    return validateBST(root.left, min, root.data) && validateBST(root.right, root.data, max);
}