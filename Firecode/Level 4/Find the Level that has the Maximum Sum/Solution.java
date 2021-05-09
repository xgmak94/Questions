/*

Given a binary tree, write a method to return the level that has the maximum sum. In case the tree is empty, return -1
Example:  
       1
      / \
     2   3     
    / \ / \  
   4  5 6  7
  /
 8   

Output ==> 2 
Note: Assume that root is at level 0.

*/

// java.util.* has been imported for this problem.
// You don't need any other imports.

public int findMaxSumLevel(TreeNode root) { 
    if(root == null)
        return -1;
    
    int max = Integer.MIN_VALUE;
    int maxLevel, levelSum, level;
    maxLevel = levelSum = level = 0;
    
    Queue<TreeNode> q = new LinkedList<>();
    Queue<TreeNode> nextLevel = new LinkedList<>();
    q.add(root);
    
    while(!q.isEmpty()) {
        TreeNode top = q.remove();
        levelSum += top.data;
        
        if(top.left != null)
            nextLevel.add(top.left);
        if(top.right != null)
            nextLevel.add(top.right);
            
        if(q.isEmpty()) {
            if(levelSum > max) {
                max = levelSum;
                maxLevel = level;
            }
            
            level++;
            levelSum = 0;
            
            while(!nextLevel.isEmpty()) {
                q.add(nextLevel.remove());
            }
        } 
    }
    return maxLevel;
}