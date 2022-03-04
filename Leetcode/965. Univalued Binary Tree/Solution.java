/* https://leetcode.com/problems/univalued-binary-tree/

A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.

Example 1:
Input: [1,1,1,1,1,null,1]
Output: true

Example 2:
Input: [2,2,2,5,2]
Output: false
*/

class Solution {
    public boolean isUnivalTree(TreeNode root) {
        Set<Integer> set = new HashSet<>();
        
        traverse(set, root);
        return set.size() == 1; //only 1 value
    }
    
    public void traverse(Set<Integer> set, TreeNode root) {
        if(root == null) return;
        set.add(root.val);
        
        traverse(set, root.left);
        traverse(set, root.right);
    }
}
