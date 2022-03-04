/*https://leetcode.com/problems/find-largest-value-in-each-tree-row

You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
*/

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> largest = new ArrayList<>();
        if(root == null) return largest; //empty no tree
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int rowSize = q.size();
            int maxRow = Integer.MIN_VALUE;
            
            for(int i = 0 ; i < rowSize ; i++) { //traverse a row
                TreeNode node = q.poll();
                maxRow = Math.max(maxRow, node.val); //max in current row

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            largest.add(maxRow);
        }
        return largest;
    }
}

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if(root == null)
            return ret;
        
        Queue<TreeNode> currLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        
        currLevel.add(root);
        int max = Integer.MIN_VALUE;
        
        while(!currLevel.isEmpty()) {
            TreeNode top = currLevel.remove();
            max = (top.val > max) ? top.val : max;

            if(top.left != null)
                nextLevel.add(top.left);
            if(top.right != null)
                nextLevel.add(top.right);
            
            if(currLevel.isEmpty()) {
                while(!nextLevel.isEmpty()) {
                    TreeNode nextLevelTop = nextLevel.remove();
                    currLevel.add(nextLevelTop);   
                }
                
                ret.add(max);
                max = Integer.MIN_VALUE;
            }
        }
        return ret;
    }
}
