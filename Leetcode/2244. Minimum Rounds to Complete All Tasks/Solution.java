/* https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/

You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.

Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

Example 1:
Input: tasks = [2,2,3,3,2,4,4,4,4,4]
Output: 4
Explanation: To complete all the tasks, a possible plan is:
- In the first round, you complete 3 tasks of difficulty level 2. 
- In the second round, you complete 2 tasks of difficulty level 3. 
- In the third round, you complete 3 tasks of difficulty level 4. 
- In the fourth round, you complete 2 tasks of difficulty level 4.  
It can be shown that all the tasks cannot be completed in fewer than 4 rounds, so the answer is 4.

Example 2:
Input: tasks = [2,3,3]
Output: -1
Explanation: There is only 1 task of difficulty level 2, but in each round, you can only complete either 2 or 3 tasks of the same difficulty level. Hence, you cannot complete all the tasks, and the answer is -1.

Constraints:
1 <= tasks.length <= 105
1 <= tasks[i] <= 109
*/


//1 -> -1 not possible
//2 -> 1
//3 -> 1
//4 -> 2
//5 -> 2
//6 -> 2
//3k -> 3*k -> k rounds
//3k+1 -> 3 * (k - 1) + 2 + 2 -> k+1 rounds
//3k+2 -> 3*k + 2 -> k+1
//3k+3 -> 3*(k+1) ->k+1

class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        int rounds = 0;
        for(int task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        
        for(int freq : map.values()) {
            if(freq == 1) { //not possible to do if only 1 task of difficulty
                return -1; 
            }
            else {
                rounds += (freq + 2) / 3;
            }
        }
        return rounds;
    }
}
