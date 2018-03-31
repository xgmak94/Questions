/*
Complete the postOrder function in your editor below, which has  parameter: a pointer to the root of a binary tree. It must print the values in the tree's postorder traversal as a single line of space-separated values.

Input Format

Our hidden tester code passes the root node of a binary tree to your postOrder function.

Constraints

1 Nodes in the tree  500

Output Format

Print the tree's postorder traversal as a single line of space-separated values.

Sample Input

     1
      \
       2
        \
         5
        /  \
       3    6
        \
         4
Sample Output

4 3 6 5 2 1 

/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

void postOrder(Node root) {
    if(root == null)
        return;
      
    postOrder(root.left);
    postOrder(root.right);
    System.out.print(root.data + " ");
}
