/* https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*/
 
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        
        return BST(nums, 0, nums.length - 1);
    }
    
    public TreeNode BST(int[] nums, int left, int right) {
        if(left > right) return null;
        
        int middle = (left + right) / 2;
        
        TreeNode newNode = new TreeNode(nums[middle]);
        newNode.left = BST(nums, left, middle - 1);
        newNode.right = BST(nums, middle + 1, right);
        
        return newNode;
    }   
}
