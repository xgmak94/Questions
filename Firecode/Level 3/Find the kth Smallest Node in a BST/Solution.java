/*

Given a binary search tree and an integer k, implement a method to find and return the kth smallest node.
Example:  
       4                                  
      / \                              
     2   8     
        / \                     
       5  10                  

K = 2, Output = 4

*/

public TreeNode findKthSmallest(TreeNode root, int k) {                   
    if(root == null) 
        return null;
        
    int leftSize = 0;
    
    if(root.left != null)
        leftSize = size(root.left);
        
    if(leftSize + 1 == k)
        return root;
    else if(k <= leftSize)
        return findKthSmallest(root.left, k);
    else
        return findKthSmallest(root.right, k-leftSize-1);
}

public TreeNode findKthLargest(TreeNode root, int k) {                   
    if(root == null) 
        return null;
        
    int rightSize = 0;
    
    if(root.right != null)
        rightSize = size(root.right);
        
    if(rightSize + 1 == k)
        return root;
    else if(k <= rightSize)
        return findKthLargest(root.right, k);
    else
        return findKthLargest(root.left, k-rightSize-1);
}