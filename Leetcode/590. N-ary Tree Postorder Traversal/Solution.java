/* https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/

Given an n-ary tree, return the postorder traversal of its nodes' values.

 
For example, given a 3-ary tree:



 
Return its postorder traversal as: [5,6,3,2,4,1].

 
Note: Recursive solution is trivial, could you do it iteratively?
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list;
    }
    
    public void traverse(Node root, List<Integer> list) {
        if(root == null)
             return;
        else {
            for(Node node : root.children) {
                traverse(node, list);
            }
            
            list.add(root.val);
        }
    }
}