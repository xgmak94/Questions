/* Implement a method to find a node in a graph using Depth First Search.
Example:  
          apple                                  
         /    \                              
     banana   mango
    /     \    /                         
 peach   strawberry       
    \     /
     cherry

Find cherry ==> true


*/

public boolean depthFirstSearch(Node rootNode, String data) {
    Stack<Node> s = new Stack<Node>();
    s.add(rootNode);
    rootNode.visited = true;
    while(!s.isEmpty()){
        Node n = s.pop();
        if(n.data != null && n.data.equals(data)) {
            return true;
        }
        for(Node adj : n.adjacentNodes){
            if(!adj.visited){
                    adj.visited = true;
                    s.push(adj);
            }
        }
    }              
    return false;
}