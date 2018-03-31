/*
Write a function to find the total number of half nodes in a binary tree. A half node is a node which has exactly one child node. If there are no half nodes, return 0.
Example:  
       1
      / \
     2   3     
    / \ / \
   4  5 6  7
  /
 8   

Half nodes count => 1
*/

public int numberOfHalfNodes(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    if(root == null) {
        return 0;
    }
    
    int count = 0;
    q.add(root);
    
    while(!q.isEmpty()) {
        TreeNode top = q.remove();
        if(top.left != null) {
            q.add(top.left);
            if(top.right == null)
                count++;
        }
        if(top.right != null) {
            q.add(top.right);
            if(top.left == null)
                count++;
        }
    }
    return count;
}

public int numberOfHalfNodes(TreeNode root) {
    int count = 0;
    if(root == null)
        return 0;
    else if (root.left == null ^ root.right == null)
        count = 1;
    return count + numberOfHalfNodes(root.left) + numberOfHalfNodes(root.right);
}