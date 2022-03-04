/* https://leetcode.com/problems/range-sum-of-bst/

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

Example 1:
Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32
Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.

Example 2:
Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23
Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.

Constraints:
The number of nodes in the tree is in the range [1, 2 * 104].
1 <= Node.val <= 105
1 <= low <= high <= 105
All Node.val are unique.
*/

class Solution {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null) return 0;
        
        int sum = 0;
        if(root.val >= L && root.val <= R) sum += root.val;
        
        sum += rangeSumBST(root.left, L, R);
        sum += rangeSumBST(root.right, L, R);
        return sum;
    }
}

class Solution {
    int rangeSum = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root != null) {
            if(root.val >= L && root.val <= R)
                rangeSum += root.val;
            if(root.val > L)
                rangeSumBST(root.left, L, R);
            if(root.val < R)
                rangeSumBST(root.right, L, R);
        }
        return rangeSum;
    }
}