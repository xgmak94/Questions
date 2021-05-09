/* https://leetcode.com/problems/binary-tree-preorder-traversal/

Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].
*/

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    public void preorder(TreeNode root, List<Integer> list) {
        if(root != null) {
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }
}

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        
        if(root == null)
            return ret;
        else
            s.push(root);
        
        while(!s.isEmpty()) {
            TreeNode top = s.pop();
            
            ret.add(top.val);
            if(top.right != null)
                s.push(top.right);
            if(top.left != null)
                s.push(top.left);
        }
        
        return ret;
    }
}
