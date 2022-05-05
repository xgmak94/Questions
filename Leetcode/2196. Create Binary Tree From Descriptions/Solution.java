/* https://leetcode.com/problems/create-binary-tree-from-descriptions/

You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,

If isLefti == 1, then childi is the left child of parenti.
If isLefti == 0, then childi is the right child of parenti.
Construct the binary tree described by descriptions and return its root.

The test cases will be generated such that the binary tree is valid.

Example 1:
Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
Output: [50,20,80,15,17,19]
Explanation: The root node is the node with value 50 since it has no parent.
The resulting binary tree is shown in the diagram.

Example 2:
Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
Output: [1,2,null,null,3,4]
Explanation: The root node is the node with value 1 since it has no parent.
The resulting binary tree is shown in the diagram.

Constraints:
1 <= descriptions.length <= 104
descriptions[i].length == 3
1 <= parenti, childi <= 105
0 <= isLefti <= 1
The binary tree described by descriptions is valid.
*/

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>(); //used to get root later
        
        for(int[] descrip : descriptions) {
            int parent = descrip[0];
            int child = descrip[1];
            int left = descrip[2];
            
            children.add(child);
            TreeNode parentNode = map.getOrDefault(parent, new TreeNode(parent));
            map.put(parent, parentNode);
            if(left == 1) {
                parentNode.left = map.getOrDefault(child, new TreeNode(child));
                map.put(child, parentNode.left);
            }
            else {
                parentNode.right = map.getOrDefault(child, new TreeNode(child));
                map.put(child, parentNode.right);
            }
        }
        return getRoot(descriptions, map, children);
    }
    public TreeNode getRoot(int[][] descriptions, Map<Integer, TreeNode> map, Set<Integer> children) {
        int root = -1;
        for(int[] descrip : descriptions) {
            int parent = descrip[0];
            if(!children.contains(parent)) { //find the parent that is not a child of any node
                root = parent;
                break;
            }
        }
        return map.getOrDefault(root, null);
    }
}
