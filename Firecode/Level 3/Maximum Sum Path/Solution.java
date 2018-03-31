/*
Given a binary tree consisting of nodes with positive integer values, write a method - maxSumPath that returns the maximum sum of data values obtained by traversing nodes along a path between any 2 nodes of the tree. The path must originate and terminate at 2 different nodes of the tree, and the maximum sum is obtained by summing all the data values of the nodes traversed along this path.

Example:  

     1
    / \
   2   3     => 18
  / \ / \
 4  5 6  7 

Path: 5 -> 2 -> 1 -> 3 -> 7
Max Sum = 5+2+1+3+7 = 18
*/

public static int maxSumPath(TreeNode root) {
    int[] maxRecursiveHolder = new int[1];
    maxSumPathMain(root, maxRecursiveHolder);
    return maxRecursiveHolder[0];
}

public static int maxSumPathMain(TreeNode root, int[] maxRecursiveHolder){
    if(root == null) return 0;
    int leftSum = maxSumPathMain(root.left, maxRecursiveHolder);
    int rightSum = maxSumPathMain(root.right, maxRecursiveHolder);
    // Get the max path sum up to this node, including this node's value
    int nodeCumVal = Math.max(root.data + leftSum, root.data + rightSum);
    // Check and update the max holder
    maxRecursiveHolder[0] = Math.max(maxRecursiveHolder[0], leftSum + root.data + rightSum);
    return nodeCumVal;
}




public static int maxSumPath(TreeNode root) {
    if (root == null) {
        return 0;
    }
    
    return root.data + maxSumPathChild(root.left) + maxSumPathChild(root.right);
}

private static int maxSumPathChild(TreeNode root) {
    if (root == null) {
        return 0;
    }
    
    return root.data + Math.max(maxSumPathChild(root.left), maxSumPathChild(root.right));
}