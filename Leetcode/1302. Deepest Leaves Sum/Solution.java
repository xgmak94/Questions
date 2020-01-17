/* https://leetcode.com/problems/deepest-leaves-sum/

Given a binary tree, return the sum of values of its deepest leaves.

Example 1:

Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int currLevelSum = 0;
        
        q.add(root);
        while(!q.isEmpty()) {
            currLevelSum = 0; //sum will be deepest leaves because q will be empty
            int levelSize = q.size();
            
            for(int i = 0 ; i < levelSize ; i++) {
                TreeNode curr = q.poll();
                currLevelSum += curr.val;
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return currLevelSum;
    }
}
