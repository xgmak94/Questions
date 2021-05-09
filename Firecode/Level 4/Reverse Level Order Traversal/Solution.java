/*
Traverse a given binary tree in the Reverse Level Order. Mark a node as visited by adding its data to an ArrayList which will be returned.
Example:  
     1
    / \
   2   3     
  / \ / \
 4  5 6  7 

Output => 4567231
*/

public ArrayList<Integer> levelorderRev(TreeNode root) {
    ArrayList<Integer> ret = new ArrayList<>();
    if(root == null)
        return ret;
    
    Stack<Integer> s = new Stack<>();
    Queue<TreeNode> q = new LinkedList<>();
    
    q.add(root);
    
    while(!q.isEmpty()) {
        TreeNode top = q.remove();
        s.add(top.data);
        if(top.right != null)
            q.add(top.right);
        if(top.left != null)
            q.add(top.left);
    }
    
    while (!s.isEmpty()) {
        int n = s.pop();
        ret.add(n);
    }
    return ret;
}