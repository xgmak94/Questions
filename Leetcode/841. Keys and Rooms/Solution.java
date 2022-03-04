/* https://leetcode.com/problems/keys-and-rooms/

There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room. 
Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
Initially, all the rooms start locked (except for room 0). 

You can walk back and forth between rooms freely.

Return true if and only if you can enter every room.

Example 1:
Input: [[1],[2],[3],[]]
Output: true
Explanation:  
We start in room 0, and pick up key 1.
We then go to room 1, and pick up key 2.
We then go to room 2, and pick up key 3.
We then go to room 3.  Since we were able to go to every room, we return true.

Example 2:
Input: [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can't enter the room with number 2.
*/

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        Set<Integer> entered = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();

        entered.add(0); //we can enter room 0
        q.addAll(rooms.get(0)); //add all the keys in room 0
        while(!q.isEmpty()) { //while we have a key
            int room = q.poll();
            if(!entered.contains(room)) {
                entered.add(room);
                q.addAll(rooms.get(room));
            }
        }
        return entered.size() == rooms.size();
    }
}

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] enter = new boolean[n];
        Arrays.fill(enter, false);
        enter[0] = true; //we have the key to room 0
        
        Queue<Integer> q = new LinkedList<>();
        q.addAll(rooms.get(0)); //add all the keys in room 0
        
        while(!q.isEmpty()) { //while we have a key
            int room = q.poll();
            if(enter[room] == false) { //if we have not entered this room yet, it is new
                enter[room] = true;  
                q.addAll(rooms.get(room));
            }
        }
        return canEnterAll(enter);
    }
    
    public boolean canEnterAll(boolean[] enter) {
        for(int i = 0 ; i < enter.length ; i++) {
            if(enter[i] == false)
                return false;
        }
        return true;
    }
}
