/* https://leetcode.com/problems/binary-tree-level-order-traversal
/* https://leetcode.com/problems/binary-tree-level-order-traversal-ii
/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/* 
Make use of a queue to do a breadth first traversal.
Then we use a series of lists to represent each level in the tree
*/

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        ArrayList<Integer> level = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return list;
        q.add(root);

        while(!q.isEmpty()) {
            int numInLevel = q.size();
            
            for(int i = 0 ; i < numInLevel ; i++) {
                TreeNode curr = q.remove();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                level.add(curr.val);
            }
            list.add(level);
            level = new ArrayList<>();
        }
        return list;
    }
}

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        ArrayList<Integer> level = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null) return list;
        q.add(root);

        while(!q.isEmpty()) {
            int numInLevel = q.size();
            
            for(int i = 0 ; i < numInLevel ; i++) {
                TreeNode curr = q.remove();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                level.add(curr.val);
            }
            list.add(level);
            level = new ArrayList<>();
        }
        Collections.reverse(list);
        return list;
    }
}
