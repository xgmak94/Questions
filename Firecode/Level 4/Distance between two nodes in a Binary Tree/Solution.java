/*
Given the root of a Binary Tree  and 2 integers that represent the data values of any two TreeNodes present in the tree, write a method - getNodeDistance that returns the distance between the nodes. 
You can assume that the given keys exist in the tree. 
The distance between two nodes is defined as the minimum number of edges that must be traversed to travel between the two nodes. 

Example: 
       1
      / \
     2   3
      \   \     
       4   5

getNodeDistance(2,5) => 3
*/

public int getNodeDistance(TreeNode root, int n1, int n2) {
    int distN1 = pathLengthFromRoot(root, n1) - 1;
    int distN2 = pathLengthFromRoot(root, n2) - 1;
    int lcaData = findLCA(root, n1, n2).data;
    int lcaDistance = pathLengthFromRoot(root, lcaData) - 1;
    return (distN1 + distN2) - 2 * lcaDistance;
}

public int pathLengthFromRoot(TreeNode root, int n1) {
    if (root == null) return 0;
    else {
        int out = 0;
        if ((root.data == n1) || (out = pathLengthFromRoot(root.left, n1)) > 0
                || (out = pathLengthFromRoot(root.right, n1)) > 0) {
            return out + 1;
        }
        return 0;
    }
}

public TreeNode findLCA(TreeNode root, int n1, int n2) {
    if (root != null) {
        if (root.data == n1 || root.data == n2) {
            return root;
        }
        TreeNode left = findLCA(root.left, n1, n2);
        TreeNode right = findLCA(root.right, n1, n2);
    
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    return null;
}