/* https://leetcode.com/problems/path-sum-ii/

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/

class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        
        getPaths(root, list, new ArrayList<>(), sum);
        return list;
    }
    
    public void getPaths(TreeNode root, List<List<Integer>> list, List<Integer> temp, int sum) {
        temp.add(root.val);
        if(root.left == null && root.right == null && root.val == sum) {
            list.add(temp);
            return;
        }
        else {
            if(root.left != null) {
                getPaths(root.left, list, new ArrayList<>(temp), sum-root.val);
            }
            if(root.right != null) {
                getPaths(root.right, list, new ArrayList<>(temp), sum-root.val);
            }
        }
    }
}
