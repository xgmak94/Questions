/*
Given a binary tree, write a method to perform a levelorder traversal and return an ArrayList of integers containing the data of the visited nodes in the correct order.
Example:  
     1
    / \
   2   3     ==> 1234567
  / \ / \
 4  5 6  7 

*/

public ArrayList<Integer> levelorder(TreeNode root) {
    ArrayList<Integer> list = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    
    if(root == null)
        return list;
    else
        q.add(root);
        
    while(!q.isEmpty()) {
        TreeNode top = q.remove();
        if(top.left != null)
            q.add(top.left);
        if(top.right != null)
            q.add(top.right);
        list.add(top.data);
    }
    return list;
}