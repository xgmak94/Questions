/*

Write a method to delete a node from a given
binary search tree
.

Example:  
   4                     4                  
  / \                   / \              
 2   8   delete 10 =>  2   8
    / \                   /   
   5  10                 5   


*/

public TreeNode delete(TreeNode root, int data) { 
	if(root == null)
		return null;
	else if(data < root.data)
		root.left = delete(root.left, data);
	else if(data > root.data)
		root.right = delete(root.right, data);
	else{
		if(root.left != null && root.right != null) {
			root.data = findMin(root.right).data;
			root.right = delete(root.right, root.data);
		}
		else if(root.left == null && root.right == null) {
			root = null;
		}
		else if(root.left == null) {
			root = root.right;
		}
		else if(root.right == null) {
			root = root.left;
		}
	}
	return root;
}

public TreeNode delete(TreeNode root, int data) {                    
    if(root == null) { 
        return null;
    } else if(data < root.data) {
        root.left = delete(root.left, data);
    } else if(data > root.data) {
        root.right = delete(root.right, data);
    } else { //element found
        if(root.left != null && root.right != null) { //full node case
            root.data = findMin(root.right).data;    
            root.right = delete(root.right, root.data);
        } else if(root.left == null && root.right == null) {
            root = null;
        }  
        else if(root.left == null) {
            root = root.right;
        } else if(root.right == null) {
            root = root.left;                
        }                
    }
    return root;
}