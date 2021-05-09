/* https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example, given a 3-ary tree:
 
We should return its level order traversal:
[
     [1],
     [3,2,4],
     [5,6]
]

Note:
The depth of the tree is at most 1000.
The total number of nodes is at most 5000.
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        
        if(root == null) //empty
            return levelOrder;

        List<Integer> level = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0 ; i < size ; i++) {
                Node curr = q.remove();
                level.add(curr.val);
                
                for(Node node : curr.children) {
                    q.add(node);
                }
            }
            levelOrder.add(level);
            level = new ArrayList<>();
        }
        return levelOrder;
    }
}
