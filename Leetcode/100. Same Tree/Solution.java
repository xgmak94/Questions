/* https://leetcode.com/problems/same-tree

Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
*/


//If they are the same tree for every node, p, in tree1 there is a node, q, in tree2 that has the same value
//They also have must be null at the same nodes 

class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) // both null
            return true;
        if(p == null || q == null || p.val != q.val) // only 1 null
            return false;
            
        if(p.val == q.val) 
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
