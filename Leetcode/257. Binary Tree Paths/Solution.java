/* https://leetcode.com/problems/binary-tree-paths/description/

Given a binary tree, return all root-to-leaf paths.

For example, given the following binary tree:

   1
 /   \
2     3
 \
  5
All root-to-leaf paths are:

["1->2->5", "1->3"]

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
    List<String> list;
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        
        if(root == null)
            return list;
        else
            binaryPaths(root, "", list);
        
        return list;
    }
    
    public void binaryPaths(TreeNode root, String s, List<String> list) {
        if(root.left == null && root.right == null) {
            list.add(s + root.val);
        }
        
        if(root.left != null) {
            binaryPaths(root.left, s + root.val + "->", list);
        }
        if(root.right != null) {
            binaryPaths(root.right, s + root.val + "->", list);
        }
    }
}
