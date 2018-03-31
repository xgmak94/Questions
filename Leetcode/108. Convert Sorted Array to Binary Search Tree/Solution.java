/* https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        
        return BST(nums, 0, nums.length - 1);
    }
    
    public TreeNode BST(int[] nums, int left, int right) {
        if(left > right)
            return null;
        
        int middle = (left + right) / 2;
        
        TreeNode newNode = new TreeNode(nums[middle]);
        newNode.left = BST(nums, left, middle - 1);
        newNode.right = BST(nums, middle + 1, right);
        
        return newNode;
    }   
}
