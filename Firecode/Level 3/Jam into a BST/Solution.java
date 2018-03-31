/*
Implement a method to insert a node into a
Binary Search Tree
. Return the root of the modified tree.

Example:
 
  4                    4
 / \                  / \ 
2   8   insert(6)=>  2   8 
   / \                  / \  
  5  10                5  10  
                        \
                         6
*/

public TreeNode insert(TreeNode root, int data) { 
    if(root == null)
        return new TreeNode(data, null, null);

    if(data < root.data)
        root.left = insert(root.left, data);
    else
        root.right = insert(root.right, data);
    return root;
}                     