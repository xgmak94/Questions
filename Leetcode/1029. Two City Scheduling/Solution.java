/* https://leetcode.com/problems/two-city-scheduling/ 

There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

Example 1:
Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.
The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int totalCost = 0;
        
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] v1, int[] v2) {
                return (v1[0] - v1[1]) - (v2[0] - v2[1]); //better to fly to city A before city B
            }});
            
        for(int i = 0 ; i < costs.length ; i++) {
            if(i < costs.length / 2) { //send first half to city A
                totalCost += costs[i][0];
            }
            else { //send second half to city B
                totalCost += costs[i][1];
            }
        }
        return totalCost;
    }
}

//slower with lambda compare for some reason
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int[] savings = new int[costs.length];
        int totalCost = 0;
        
        Arrays.sort(costs, (v1,v2) -> (v1[0] - v1[1]) - (v2[0] - v2[1]));
            
        for(int i = 0 ; i < costs.length ; i++) {
            if(i < costs.length / 2)
                totalCost += costs[i][0];
            else
                totalCost += costs[i][1];
        }
        return totalCost;
    }
}
