/* https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level X such that the sum of all the values of nodes at level X is maximal.

Example 1:
Input: [1,7,0,7,-8,null,null]
Output: 2
Explanation: 
Level 1 sum = 1.
Level 2 sum = 7 + 0 = 7.
Level 3 sum = 7 + -8 = -1.
So we return the level with the maximum sum which is level 2.
*/

class Solution {
    public int maxLevelSum(TreeNode root) {   
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int maxSum = Integer.MIN_VALUE;
        int maxLevel = 0;        
        int currLevel = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            int sum = 0;
            
            for(int i = 0 ; i < size ; i++) {
                TreeNode curr = q.remove();
                sum += curr.val;
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            
            if(sum > maxSum) {
                maxLevel = currLevel;
                maxSum = sum;
            }
            currLevel++;
        }
        return maxLevel;     
    }
}
