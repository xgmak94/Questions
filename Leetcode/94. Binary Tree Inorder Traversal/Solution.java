/* https://leetcode.com/problems/binary-tree-inorder-traversal
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree [1,null,2,3],
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
*/

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
    
    public void traverse(TreeNode root, List<Integer> list) {
        if(root == null) return;
        traverse(root.left, list);
        list.add(root.val);
        traverse(root.right, list);
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> ret = new ArrayList<>();
        
        TreeNode curr = root;
        
        while(curr != null || !s.isEmpty()) {
            while(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            ret.add(curr.val);
            curr = curr.right;
        }
        return ret;
    }
}
