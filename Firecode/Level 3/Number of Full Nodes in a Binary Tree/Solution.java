/*
Write a function to iteratively determine the total number of "full nodes" in a binary tree. 
A full node contains left and right child nodes. 
If there are no full nodes, return 0.

Example:  
       1
      / \
     2   3   
    / \ / \
   4  5 6  7
  / \
 8   9

Full nodes count ==> 4
*/

public int numberOfFullNodes(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    int fullNodes = 0;
    
    if(root == null)
        return 0;
    else
        q.add(root);
    
    while(!q.isEmpty()) {
        TreeNode top = q.remove();
        if(top.left != null && top.right != null)
            fullNodes++;
        if(top.left != null)
            q.add(top.left);
        if(top.right != null)
            q.add(top.right);
    }
    return fullNodes;
}