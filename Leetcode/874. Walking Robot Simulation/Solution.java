/* https://leetcode.com/problems/walking-robot-simulation/

A robot on an infinite grid starts at point (0, 0) and faces north.  The robot can receive one of three possible types of commands:

-2: turn left 90 degrees
-1: turn right 90 degrees
1 <= x <= 9: move forward x units
Some of the grid squares are obstacles. 

The i-th obstacle is at grid point (obstacles[i][0], obstacles[i][1])

If the robot would try to move onto them, the robot stays on the previous grid square instead (but still continues following the rest of the route.)

Return the square of the maximum Euclidean distance that the robot will be from the origin.

Example 1:
Input: commands = [4,-1,3], obstacles = []
Output: 25
Explanation: robot will go to (3, 4)

Example 2:
Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
Output: 65
Explanation: robot will be stuck at (1, 4) before turning left and going to (1, 8)

Note:
0 <= commands.length <= 10000
0 <= obstacles.length <= 10000
-30000 <= obstacle[i][0] <= 30000
-30000 <= obstacle[i][1] <= 30000
The answer is guaranteed to be less than 2 ^ 31.
*/

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        Set<String> set = new HashSet<>();
        for(int[] obstacle : obstacles) {
            set.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0, y = 0;
        int maxDist = 0;
        int dir = 1; // index in dir
        for(int command : commands) {
            if(command == -1) {
                dir++;
                if(dir == 4) dir = 0;
            }
            else if(command == -2) {
                dir--;
                if(dir == -1) dir = 3;
            }
            else { // 1-9
                while(command > 0 && !set.contains((x + dirs[dir][0] + " " + (y + dirs[dir][1])))) {
                    command--;
                    x += dirs[dir][0];
                    y += dirs[dir][1];
                }
            }
            maxDist = Math.max(maxDist, x*x+y*y);
        }
        return maxDist;
    }
}
