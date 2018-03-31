/* https://leetcode.com/problems/binary-tree-level-order-traversal-ii

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
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

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if(root == null)
            return ret;
        else
            q.add(root);

        while(!q.isEmpty()) {
            int numInLevel = q.size();
            
            for(int i = 0 ; i < numInLevel ; i++) {
                TreeNode top = q.remove();
                if(top.left != null)
                    q.add(top.left);
                if(top.right != null)
                    q.add(top.right);
                list.add(top.val);
            }
            ret.add(0, list);
            list = new ArrayList<>();
        }
        return ret;
    }
}
