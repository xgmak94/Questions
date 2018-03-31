/*
Given a binary tree, write a method to find and return its deepest node. Return null for an empty tree.
Example:  
       1
      / \
     2   3     ==> deepest = 9
    / \ / \
   4  5 6  7
  / \
 8   9
*/

public TreeNode findDeepest(TreeNode root) { 
    if(root == null)
        return null;
    
    Queue<TreeNode> q = new LinkedList<TreeNode>();

    q.add(root);
    TreeNode top = null;
    while(!q.isEmpty()) {
        top = q.remove();
        if(top.left != null)
            q.add(top.left);
        if(top.right != null)
            q.add(top.right);
    }
    return top;
}