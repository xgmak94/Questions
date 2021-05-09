/* https://leetcode.com/problems/all-elements-in-two-binary-search-trees/

Given two binary search trees root1 and root2.
Return a list containing all the integers from both trees sorted in ascending order.

Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:
Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:
Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]
*/

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ret = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        if(root1 != null) q.add(root1);
        if(root2 != null) q.add(root2);
        while(!q.isEmpty()) {
            TreeNode top = q.remove();
            ret.add(top.val);
            if(top.left != null) q.add(top.left);
            if(top.right != null) q.add(top.right);
        }
        Collections.sort(ret);
        return ret;	
    }
}
