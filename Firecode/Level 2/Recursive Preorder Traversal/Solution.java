/*
Given a binary tree, write a method to recursively traverse the tree in the preorder manner. Mark a node as visited by adding its data to the list - Arraylist <Integer> preorderedList.
Example:  
     1
    / \
   2   3     ==> 1245367
  / \ / \
 4  5 6  7 
*/

ArrayList<Integer> preorderedList = new ArrayList<Integer>();

public void preorder(TreeNode root) {
    if(root == null)
        return;
    
    preorderedList.add(root.data);
    
    preorder(root.left);
    preorder(root.right);
}