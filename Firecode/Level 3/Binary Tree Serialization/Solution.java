/*
In Computer Science, serialization is the process of converting objects or data structures into a sequence (or series) of characters that can be stored easily in a file / database table or transmitted across a network. 
Serialized objects need to be de-serialized to create a semantically identical clone of the original object, before being used in programs. 
You're given the root node of a binary tree - TreeNode root in the method serializeTree. 
This method should serialize the binary tree and output a String str, which is then used as an input parameter for the method restoreTree. 
restoreTree should create a Binary Tree that is structurally identical to the one you serialized and return the root node of the tree. 
Your task is to fill in the logic for these 2 methods. 
Don't worry about passing the serialized String to restoreTree - that will be done automatically when you run your code. 
Feel free to use any notation you prefer when serializing the binary tree. 
The choice of traversal algorithm is also open - but try and limit the time complexity of both methods to O(n).

Note: 
Your serialized String will be used to restore the tree. Be sure to use the same format and notation in restoreTree that you use to serialize in  serializeTree .

Example:  
     1
    / \
   2   3

Serialization : 
Output => "1,2,3"

Restoring Tree from "1,2,3" : 
Output -> 

     1
    / \
   2   3
*/

public String serializeTree(TreeNode root){
    StringBuilder sb = new StringBuilder();
    serializeTreeHelper(root,sb);
    if(sb.length() > 0) sb.deleteCharAt(0);
    return sb.toString();
}

private StringBuilder serializeTreeHelper(TreeNode t, StringBuilder sb){
    if(t == null) sb.append(",null");
    else {
        sb.append(","+t.data);
        serializeTreeHelper(t.left, sb);
        serializeTreeHelper(t.right, sb);
    }
    return sb;
}

public TreeNode restoreTree(String str){
    String[] nodesSplit = str.split(",");
    LinkedList<String> nodesList = new LinkedList<>(Arrays.asList(nodesSplit));
    return restoreTreeHelper(nodesList);
}

public TreeNode restoreTreeHelper(LinkedList<String> nodes){
    String nodeDataStr = nodes.remove();
    if(nodeDataStr.equals("null")) return null;
    TreeNode t = new TreeNode(Integer.valueOf(nodeDataStr));
    t.left = restoreTreeHelper(nodes);
    t.right = restoreTreeHelper(nodes);
    return t;
}