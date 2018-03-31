/* https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].


/**
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if(root == null) return ret;
        
        Queue<TreeNode> level = new LinkedList<>();     
        level.add(root);
        
        while(!level.isEmpty()) {
            int n = level.size();
            double sum = 0;
            
            for(int i = 0 ; i < n ; i++) {
                TreeNode node = level.poll();
                sum += node.val;
                
                if(node.left != null) level.add(node.left);
                if(node.right != null) level.add(node.right);
            }
            
            ret.add(sum / n);
        }
        return ret;
    }
}

public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<>();
        if(root == null)
            return ret;
        
        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        
        currLevel.add(root);
        double sum = 0;
        int countLevel = 0;
        
        while(!currLevel.isEmpty()) {
            TreeNode top = currLevel.remove();
            sum += top.val;
            countLevel++;

            if(top.left != null)
                nextLevel.add(top.left);
            if(top.right != null)
                nextLevel.add(top.right);
            
            if(currLevel.isEmpty()) {
                while(!nextLevel.isEmpty()) {
                    TreeNode nextLevelTop = nextLevel.remove();
                    currLevel.add(nextLevelTop);   
                }
                
                ret.add(sum / countLevel);
                sum = 0;
                countLevel = 0;
            }
        }
        return ret;
    }
}
