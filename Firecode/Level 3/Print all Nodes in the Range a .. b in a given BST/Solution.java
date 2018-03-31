/*
Given a
Binary Search Tree
and two numbers - a & b, return all the nodes in the tree that lie in the range [a .. b]. Your method should return an ArrayList with the data of the qualifying nodes inserted in ascending order.


Example:  
       4                                  
      / \                              
     2   8  
        / \                     
       5  10                  

Range (2,8) ==> [2, 4, 5, 8]

Range includes 2 & 8

*/

public  ArrayList<Integer> rangeList = new ArrayList<Integer>();
public void printRange(TreeNode root, int a, int b) {                   
    if(root == null) return;
    if(root.data >= a) {
        printRange(root.left, a, b);
    }
    if (root.data >= a && root.data <= b) {
        rangeList.add(root.data);
        
    } 
    if(root.data <= b) {
        printRange(root.right, a, b);
    }
}