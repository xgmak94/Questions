/* https://www.hackerrank.com/challenges/tree-level-order-traversal/

You are given a pointer to the root of a binary tree. You need to print the level order traversal of this tree. In level order traversal, we visit the nodes level by level from left to right. You only have to complete the function. For example:

     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4  
For the above tree, the level order traversal is 1 -> 2 -> 5 -> 3 -> 6 -> 4.

Input Format

You are given a function,

void levelOrder(node * root) {

}

*/

   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */
   void levelOrder(Node root) {
       Queue<Node> q = new LinkedList<>();
       
       if(root == null)
           return;
       else
           q.add(root);
       
       while(!q.isEmpty()) {
           Node top = q.remove();
           
           if(top.left != null)
               q.add(top.left);
           if(top.right != null)
               q.add(top.right);
           
           System.out.print(top.data + " ");
       }
    }
