/* https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

In a list of songs, the i-th song has a duration of time[i] seconds. 

Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.

Example 1:
Input: [30,20,150,100,40]
Output: 3
Explanation: Three pairs have a total duration divisible by 60:
(time[0] = 30, time[2] = 150): total duration 180
(time[1] = 20, time[3] = 100): total duration 120
(time[1] = 20, time[4] = 40): total duration 60

Example 2:
Input: [60,60,60]
Output: 3
Explanation: All three pairs have a total duration of 120, which is divisible by 60.
*/

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int numPairs = 0;
        int[] secs = new int[60];
        
        for(int t : time) {
            int sec = t % 60;
            numPairs += secs[(60 - sec) % 60];
            secs[sec % 60]++;
        }
        return numPairs;
    }
}

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int numPairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int num : time) {
            int secs = num % 60;
            
            if(map.get((60 - secs) % 60) != null) 
                numPairs += map.get((60 - secs) % 60);
            
            map.put(secs, map.getOrDefault(secs, 0) + 1);
        }
        return numPairs;
    }
}

