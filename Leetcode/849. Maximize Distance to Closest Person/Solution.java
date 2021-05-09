/* https://leetcode.com/problems/maximize-distance-to-closest-person/description/

In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.

Example 1:
Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.

Example 2:
Input: [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
*/

class Solution {
    public int maxDistToClosest(int[] seats) {
        int lastSeat = -1;
        int maxDist = 0;
        for(int i = 0; i < seats.length ; i++) {
            if(seats[i] == 1) {
                if(lastSeat == -1) {
                    maxDist = i; //this is the first seat we saw taken, we should sit at 0 then
                }
                else {
                    maxDist = Math.max(maxDist, (i-lastSeat) / 2); //we want to sit between the last taken seat and this current seat
                }
                lastSeat = i; //new last seat
            }
        }
        maxDist = Math.max(maxDist, seats.length-lastSeat-1);
        return maxDist;
    }
}

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Arrays.fill(left, n); //default to max distance
        Arrays.fill(right, n); //default to max distance
        
        for(int i = 0 ; i < n ; i++) {
            if(seats[i] == 1) { //dist to closest 1 is 0, itself
                left[i] = 0;
            }
            else if(i > 0) {
                left[i] = left[i-1] + 1;
            }
        }
        
        for(int i = n - 1 ; i >= 0 ; i--) {
            if(seats[i] == 1) { //dist to closest 1 is 0, itself
                right[i] = 0;
            }
            else if(i < n - 1) {
                right[i] = right[i+1] + 1;
            }
        }
        
        int max = 0;
        for(int i = 0 ; i < n ; i++) {
            max = Math.max(max, Math.min(left[i], right[i]));
        }
        return max;
    }
}
