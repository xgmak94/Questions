/*
Given the root node of a Binary Tree, write a method - validateBSTItr to iteratively determine if it is a Binary Search Tree.

A BST must satisfy the following conditions :
* The left subtree of a node contains nodes with data < its data.
* The right subtree of a node contains  nodes data > its data.
* A node's left and right subtrees follow the above two conditions.

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

public static boolean validateBSTItr(TreeNode root) {

    class TreeBoundaryNode{
      TreeNode treeNode;
      int leftBoundary;
      int rightBoundary;
      TreeBoundaryNode(TreeNode treeNode, int leftBoundary, int rightBoundary) {
          this.treeNode = treeNode;
          this.leftBoundary = leftBoundary;
          this.rightBoundary = rightBoundary;
      }
    }
    
    if(root == null || (root.left == null && root.right == null)) return true;
    
    Queue<TreeBoundaryNode> q = new LinkedList<>();
    q.add(new TreeBoundaryNode(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    while(!q.isEmpty()){
        TreeBoundaryNode tbNode = q.poll();
        TreeNode t = tbNode.treeNode;
        if((t.data <= tbNode.leftBoundary) || (t.data >= tbNode.rightBoundary)) return false;
        if(t.left != null){
            q.add(new TreeBoundaryNode(t.left, tbNode.leftBoundary, t.data));
        }
        if(t.right != null){
            q.add(new TreeBoundaryNode(t.right, t.data, tbNode.rightBoundary));
        }
    }

    return true;
}