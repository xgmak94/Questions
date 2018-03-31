/* https://leetcode.com/problems/maximum-binary-tree/description/

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length-1);
    }
    
    public TreeNode construct(int[] nums, int left, int right) {
        if(left > right)
            return null;
        int max = max(nums, left, right);
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums, left, max - 1);
        root.right = construct(nums, max + 1, right);
        
        return root;
    }
    
    public int max(int[] nums, int left, int right) {
        //returns index of max from nums[left] to nums[right] inclusive
        int max = left;
        
        for(int i = left ; i <= right ; i++) {
            if(nums[i] > nums[max])
                max = i;
        }
        return max;
    }
}



class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    
    public TreeNode construct(int[] nums, int left, int right) {
        if(left == right)
            return null;
        
        int max = max(nums, left, right);
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums, left, max);
        root.right = construct(nums, max + 1, right);
        
        return root;
    }
    
    public int max(int[] nums, int left, int right) {
        int maxIndex = left;
        for(int i = left + 1 ; i < right ; i++)
            if(nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        return maxIndex;
    }
}
