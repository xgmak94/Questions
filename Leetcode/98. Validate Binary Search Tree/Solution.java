/* https://leetcode.com/problems/validate-binary-search-tree/description/

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.

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

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode pre = null;
        
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(pre != null && pre.val >= root.val)
                return false;
            pre = root;            
            root = root.right;
        }
        return true;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {      
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(list.size() > 0 && list.get(list.size() - 1) >= root.val) {
                return false;
            }
            list.add(root.val);
            root = root.right;
        }
        return true;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {      
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        
        while(root != null || !s.isEmpty()) {
            while(root != null) {
                s.push(root);
                root = root.left;
            }
            root = s.pop();
            if(list.size() > 0 && list.get(list.size() - 1) >= root.val) {
                return false;
            }
            list.add(root.val);
            root = root.right;
        }
              
        for(int i = 0 ; i < list.size() - 1 ; i++) {
            if(list.get(i) >= list.get(i+1)) {
                return false;
            }
        }
        return true;
    }
}