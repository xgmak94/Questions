/*
Given a binary tree, write a method to find and return the node with data = the input data. Do not use recursion.

Example:  
       1              
      / \            
     2   3    
    / \ / \          
   4  5 6  7         

findNode(root, 5) ==> 5

Note: Return null, if desired node is not found.
*/

public TreeNode findNode(TreeNode root, int val) {
    if(root == null)
        return null;
    
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);

    while(!q.isEmpty()) {
        TreeNode top = q.remove();
        
        if(top.data == val)
            return top;
        
        if(top.left != null)
            q.add(top.left);
        if(top.right != null)
            q.add(top.right);
    }
    return null;
}