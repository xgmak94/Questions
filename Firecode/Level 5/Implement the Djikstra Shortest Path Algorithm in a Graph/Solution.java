/* 

Implement a method to compute the shortest path from source to target in a graph using Djikstra Algorithm. The method should return a List of Vertices denoting the optimal path. Click "Use Me" to understand the Vertex and Edge classes.

Example:

     V2
    |   \  
    |10  \3
    |   5 \    7
    V0 ——-- V1 ——— V4
      \          /
       \8       /2
        \      /
           V3

 v0 = Rville
 v1 = Bville
 v2 = Gville
 v3 = Oville
 v4 = Pville

Shortest Path to V3 from V0 = [Rville, Oville]


*/

public static List<Vertex> getShortestPath(Vertex source, Vertex target) {
    computePaths(source);
    return getShortestPathTo(target);
}

public static List<Vertex> getShortestPathTo(Vertex target) {
    List<Vertex> path = new ArrayList<Vertex>();
    for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
        path.add(vertex);
    Collections.reverse(path);
    return path;
}

// Helper function to compute shortest path and store in each vertex
public static void computePaths(Vertex source) {
    source.minDistance = 0.;
    PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
    vertexQueue.add(source);

    while (!vertexQueue.isEmpty()) {
        Vertex u = vertexQueue.poll();
        // Visit each edge exiting u
        for (Edge e : u.adjacencies) {
            Vertex v = e.target;
            double weight = e.weight;
            double distanceThroughU = u.minDistance + weight;
            if (distanceThroughU < v.minDistance) {
                vertexQueue.remove(v);
                v.minDistance = distanceThroughU ;
                v.previous = u;
                vertexQueue.add(v);
            }
        }
    }
}