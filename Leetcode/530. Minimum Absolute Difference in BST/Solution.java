/* https://leetcode.com/problems/minimum-absolute-difference-in-bst/
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.

Example:

Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
*/

class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        getMinimumDifference(root.left);
        
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return min;
    }
    
}

class Solution {
    public int getMinimumDifference(TreeNode root) {
        if(root == null)
            return -1;
        
        TreeSet<Integer> set = new TreeSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        int minDiff = Integer.MAX_VALUE;
        
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode top = q.remove();
            if(top.left != null)
                q.add(top.left);
            if(top.right != null)
                q.add(top.right);
            set.add(top.val);
        }
        
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode top = q.remove();
            if(top.left != null)
                q.add(top.left);
            if(top.right != null)
                q.add(top.right);
            
            if(set.lower(top.val) != null)
                minDiff = (top.val - set.lower(top.val) < minDiff) ? top.val - set.lower(top.val) : minDiff;
            
            if(set.higher(top.val) != null)
                minDiff = (set.higher(top.val) - top.val < minDiff) ? set.higher(top.val) - top.val : minDiff;
        }
        return minDiff;
    }
}
