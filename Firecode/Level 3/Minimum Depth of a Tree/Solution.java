/*
Write a non-recursive method minTreeDepth that takes in the root node of a Binary Tree and returns the minimum depth of the tree. 
The minimum depth is defined as the least number of node traversals needed to reach a leaf from the root node. 
Your method should run in linear O(n) time and use at max O(n) space.
*/

public int minTreeDepth(TreeNode root) {
    if(root == null) {
        return 0;
    }
    if(root.left == null && root.right == null) {
        return 1;
    }
    return Math.min(1 + minTreeDepth(root.left), 1 + minTreeDepth(root.right));
}

public int minTreeDepth(TreeNode root) {
   if (root == null) return 0;
   
   int depth = 1;
   
   Queue<TreeNode> currLevel = new LinkedList<>();
   Queue<TreeNode> nextLevel = new LinkedList<>();
   
   currLevel.add(root);
   
   while (!currLevel.isEmpty()) {
      TreeNode node = currLevel.poll(); 
      if (node.left == null && node.right == null) return depth;
      if (node.left != null) nextLevel.add(node.left);
      if (node.right != null) nextLevel.add(node.right);
      if (currLevel.isEmpty()) {
          currLevel = nextLevel;
          nextLevel = new LinkedList<>();
          depth++;
      }
   }
   
   return depth;
}