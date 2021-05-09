/* https://leetcode.com/problems/deepest-leaves-sum/

Given a binary tree, return the sum of values of its deepest leaves.

Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15
*/

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        int currLevelSum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int levelSize = q.size();
            currLevelSum = 0;
            
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
