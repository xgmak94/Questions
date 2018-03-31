/*
Given a binary tree, write a method to print the tree level by level.

Example:  
     1                
    / \             
   2   3   
  / \ / \           
 4  5 6  7 

  ==>  [1][2, 3][4, 5, 6, 7]


Note: Each item in the list is an ArrayList of the format [A[], B,[] .....], where A[],B[].... are the nodes at a particular level, stored in an ArrayList.
*/

public ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {                         
      ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> level =new ArrayList<Integer>();
      
      if(root == null) return list;        
      Queue<TreeNode> currLvl = new LinkedList<TreeNode>();
      Queue<TreeNode> nextLvl = new LinkedList<TreeNode>();
      currLvl.add(root);
                   
      while(!currLvl.isEmpty()) {            
          TreeNode curr = currLvl.remove();
          if(curr !=null) { 
              level.add(curr.data);
              nextLvl.add(curr.left);
              nextLvl.add(curr.right);
          }
          if(currLvl.isEmpty()) {
              if(!level.isEmpty())
                  list.add(level);
              level = new ArrayList<Integer>();
              while(!nextLvl.isEmpty()) {
                  currLvl.add(nextLvl.remove());                    
              }
          }
      }        
      return list;   
  }