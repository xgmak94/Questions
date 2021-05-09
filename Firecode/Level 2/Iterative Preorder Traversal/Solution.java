/*
Given a binary tree, write a method to iteratively traverse the tree in the preorder manner. 
Mark a node as visited by adding its data to a list - Arraylist <Integer> preorderedList. 
Return this list.

Example:  
     1
    / \
   2   3     ==> 1245367
  / \ / \
 4  5 6  7 
*/

public ArrayList<Integer> preorderItr(TreeNode root) {                   
	ArrayList<Integer> preorderedList =  new ArrayList<Integer>();
	Stack<TreeNode> s = new Stack<TreeNode>();

	if (root == null){return preorderedList;}

	s.push(root);
	while(!s.isEmpty()) {
	  root = s.pop();
	  preorderedList.add(root.data);
	  if (root.right != null) {s.push(root.right);}
	  if (root.left  != null) {s.push(root.left);}
	}
	return preorderedList;
}