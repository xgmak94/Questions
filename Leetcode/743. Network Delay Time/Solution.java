/* https://leetcode.com/problems/network-delay-time/

There are N network nodes, labelled 1 to N.

Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node, and w is the time it takes for a signal to travel from source to target.

Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.

Example 1:
Input: times = [[2,1,1],[2,3,1],[3,4,1]], N = 4, K = 2
Output: 2

Note:
N will be in the range [1, 100].
K will be in the range [1, N].
The length of times will be in the range [1, 6000].
All edges times[i] = (u, v, w) will have 1 <= u, v <= N and 0 <= w <= 100.
*/

class Solution {
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, Map<Integer,Integer>> map = new HashMap<>();
        for(int[] time : times) {
            int src = time[0];
            int dest = time[1];
            int trav = time[2];
            
            map.putIfAbsent(src, new HashMap<>());
            map.get(src).put(dest, trav); //source, (target, time)
        }
        
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0] - b[0]));
        pq.add(new int[]{0, K});
        
        boolean[] visited = new boolean[N+1];
        int dist = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.remove();
            int curNode = cur[1];
            int curDist = cur[0];

            if(visited[curNode]) continue; //we reached this node before
            visited[curNode] = true; //we have now seen this node
            dist = curDist;
            N--; //this is the amount of nodes we need to see
            if(map.containsKey(curNode)) { //add all the nodes that can be reached 
                for(int next : map.get(curNode).keySet()){
                    pq.add(new int[]{curDist + map.get(curNode).get(next), next});
                }
            }
        }
        return N == 0 ? dist : -1;
    }
}
