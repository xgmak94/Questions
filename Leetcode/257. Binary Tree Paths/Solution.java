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

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root != null) binaryPaths(root, "", list);
     
        return list;
    }
    
    public void binaryPaths(TreeNode root, String path, List<String> list) {
        if(root.left == null && root.right == null) { //leaf node add to list
            list.add(s + root.val);
        }
        
        if(root.left != null) {
            binaryPaths(root.left, path + root.val + "->", list);
        }
        if(root.right != null) {
            binaryPaths(root.right, path + root.val + "->", list);
        }
    }
}
