/* https://leetcode.com/problems/kth-smallest-element-in-a-bst/

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
*/

//preorder traversal with a counter
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        int count = 0;
        
        while(!s.isEmpty() || curr != null) {
            if(curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            else {
                TreeNode node = s.pop();
                count++;
                if(count == k) {
                    return node.val;
                }
                curr = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }
}