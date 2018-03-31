/*https://leetcode.com/problems/find-largest-value-in-each-tree-row

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int n = q.size();
            int max = Integer.MIN_VALUE;
            
            for(int i = 0 ; i < n ; i++) {
                TreeNode top = q.poll();
                max = Math.max(top.val, max);

                if(top.left != null)
                    q.add(top.left);
                if(top.right != null)
                    q.add(top.right);
            }
            ret.add(max);
        }
        return ret;
    }
}

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        
        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        
        currLevel.add(root);
        int max = Integer.MIN_VALUE;
        
        while(!currLevel.isEmpty()) {
            TreeNode top = currLevel.remove();
            max = (top.val > max) ? top.val : max;

            if(top.left != null)
                nextLevel.add(top.left);
            if(top.right != null)
                nextLevel.add(top.right);
            
            if(currLevel.isEmpty()) {
                while(!nextLevel.isEmpty()) {
                    TreeNode nextLevelTop = nextLevel.remove();
                    currLevel.add(nextLevelTop);   
                }
                
                ret.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return ret;
    }
}