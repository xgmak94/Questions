/* https://leetcode.com/problems/binary-tree-right-side-view/

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
*/

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> view = new ArrayList<>();
        if(root == null) return view;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int levelSize = q.size();
            for(int i = 0 ; i < levelSize ; i++) {
                TreeNode curr = q.poll();
                if(i == 0) view.add(curr.val);
                if(curr.right != null) q.add(curr.right);
                if(curr.left != null) q.add(curr.left);
            }
        }
        return view;
    }
}
