/*
Given the root of a Binary Tree  and an integer that represents the data value of a TreeNode present in the tree, write a method - pathLengthFromRoot that returns the distance between the root and that node. You can assume that the given key exists in the tree. The distance is defined as the minimum number of nodes that must be traversed to reach the target node.

Example: 
       1
      / \
     2   3
      \   \     
       4   5

pathLengthFromRoot(root,5) => 3
pathLengthFromRoot(root,1) => 1
pathLengthFromRoot(root,3) => 2
*/

public int pathLengthFromRoot(TreeNode root, int n1) {
    if(root == null)
        return 0;
    else if(root.data == n1)
        return 1;
    else
        return 1 + Math.max(pathLengthFromRoot(root.left, n1), pathLengthFromRoot(root.right, n1));
}