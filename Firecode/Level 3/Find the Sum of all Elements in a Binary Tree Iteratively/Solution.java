/*
Given a binary tree, write a method to find and return the sum of all nodes of the tree iteratively.
Example:  
       1
      / \
     2   3    
    / \ / \        
   4  5 6  7
  /
 8   
  ==> sum of all nodes = 36 
  (1+2+3+4+5+6+7+8)
*/

public int sumItr(TreeNode root) { 
    Queue<TreeNode> q = new LinkedList<>();
   
    int sum = 0;
    if(root == null)
        return sum;
    else 
        q.add(root);
    
    while(!q.isEmpty()) {
        TreeNode top = q.remove();
        sum += top.data;
        
        if(top.left != null)
            q.add(top.left);
        if(top.right != null)
            q.add(top.right);
    }
    
    return sum;
}