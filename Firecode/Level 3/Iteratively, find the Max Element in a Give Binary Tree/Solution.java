/*
Write a method to find the maximum element in a binary tree iteratively.
Examples:  
     1                
    / \             
   2   3     ==>  7
  / \ / \           
 4  5 6  7 
*/

public int findMaxItr(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    
    q.add(root);
    
    int max = Integer.MIN_VALUE;
    
    while(!q.isEmpty()) {
        TreeNode top = q.remove();
        max = (top.data > max) ? top.data : max;
        
        if(top.left != null)
            q.add(top.left);
        if(top.right != null)
            q.add(top.right);
    }
    return max;
}
