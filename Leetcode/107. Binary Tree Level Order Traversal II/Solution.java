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

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int levelSize = q.size();
            
            for(int i = 0 ; i < levelSize ; i++) {
                TreeNode top = q.remove();
                if(top.left != null) q.add(top.left);
                if(top.right != null) q.add(top.right);
                list.add(top.val);
            }
            ret.add(0, list); //add to beginning of list
        }
        return ret;
    }
}
