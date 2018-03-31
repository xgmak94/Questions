/* https://leetcode.com/problems/symmetric-tree/description/

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

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

/* We make use of breadth first traversal from both the left and right side concurrently
Allowing us to check that if the values are equal then the tree is considered valid

    1
   / \
  2   2
 / \ / \
3  4 4  3
*/        

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.remove();
            TreeNode t2 = q.remove();
            
            if (t1 == null && t2 == null) // if they are both null or both values are equal continue 
                continue;
            else if (t1 == null || t2 == null || t1.val != t2.val) // if only one is null or the values are not the same it is not symmetric;
                return false;
            
            q.add(t1.left);
            q.add(t2.right);
            
            q.add(t1.right);
            q.add(t2.left);
        }
        return true;
    }
}

public class Solution {
    public boolean isSymmetric(TreeNode root) {
      return mirror(root, root);
    }

    public boolean mirror(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
          return true;
        if(t1 == null || t2 == null)
          return false;

        return t1.val == t2.val && mirror(t1.left, t2.right) && mirror(t2.right, t1.left);
    }
}
