/* https://leetcode.com/problems/binary-tree-level-order-traversal/

Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]

Example 2:
Input: root = [1]
Output: [[1]]

Example 3:
Input: root = []
Output: []

Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
*/

/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function(root) {
    if(root === null) return [];
    
    let traversal = [];
    let level = [];
    let q = [];
    q.push(root);
    while(q.length > 0) {
        let len = q.length;
        for(let i = 0 ; i < len ; i++) {
            let pop = q.shift();
            if(pop.left !== null) q.push(pop.left);
            if(pop.right !== null) q.push(pop.right);
            level.push(pop.val);
        }
        traversal.push(level[level.length-1]);
        level = [];
    }
    return traversal;
};


