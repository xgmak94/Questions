/*
Given a binary tree, write a method to perform the inorder traversal iteratively. Append the data of each node visited to an ArrayList. Return an empty Arraylist in the case of an empty tree.
Example:  
     1
    / \
   2   3     ==> 4251637
  / \ / \
 4  5 6  7 
*/

public ArrayList<Integer> inorderItr(TreeNode root) {                  
    ArrayList<Integer> inorderedList = new ArrayList<Integer>();
    Stack<TreeNode> s = new Stack<TreeNode>();
    
    TreeNode curr = root;
    while(true) {
      while(curr != null) {
          s.push(curr);
          curr = curr.left;
      }
      if(s.isEmpty()) {
        return inorderedList;
      }
      else {
          curr = s.pop();
          inorderedList.add(curr.data);
          
          curr = curr.right;
      }
    }
}