/* https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:
     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL

*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode levelBegin = root;
        while(levelBegin != null) {
            TreeLinkNode curr = levelBegin;
            while(curr != null) {
            	if(curr.left != null)
            		curr.left.next = curr.right;

        		if(curr.right != null && curr.next != null)
        			curr.right.next = curr.next.left;
        		else if(curr.right != null && curr.next == null)
        			curr.right.next = null;

        		curr = curr.next;
            }
            levelBegin = levelBegin.left;
        }
    }
}

public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        
        int levelSize = 1;
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            for(int i = 0 ; i < levelSize ; i++) {
                TreeLinkNode curr = q.remove();
                if(q.peek() == null || i == levelSize - 1) {
                    curr.next = null;
                }
                else {
                    curr.next = q.peek();
                }
                
                if(curr.left != null && curr.right != null) { //balanced tree
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }
            levelSize *= 2;
        }
    }
}
