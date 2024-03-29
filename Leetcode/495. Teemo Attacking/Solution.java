/* https://leetcode.com/problems/teemo-attacking

In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition. 
Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking, you need to output the total time that Ashe is in poisoned condition.

You may assume that Teemo attacks at the very beginning of a specific time point, and makes Ashe be in poisoned condition immediately.

Example 1:
Input: [1,4], 2
Output: 4
Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately. 
This poisoned status will last 2 seconds until the end of time point 2. 
And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds. 
So you finally need to output 4.

Example 2:
Input: [1,2], 2
Output: 3
Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned. 
This poisoned status will last 2 seconds until the end of time point 2. 
However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status. 
Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of time point 3. 
So you finally need to output 3.
*/

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;

        int length = 0;
        int start = 0;
        int end = 0;

        for(int i = 0 ; i < timeSeries.length ; i++) {
            if(timeSeries[i] <= end) { //extended
                end = timeSeries[i] + duration;
            }
            else { //current poison is over add it to length
                length += end-start;
                start = timeSeries[i];
                end = timeSeries[i] + duration;
            }
        }
        length += end-start; //final duration
        return length;
    }
}

class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries == null || timeSeries.length == 0 || duration == 0) return 0;
        
        int length = 0;
        for(int i = 0 ; i < timeSeries.length ; i++) {
            int start = timeSeries[i];
            int end = timeSeries[i] + duration;
            if(i + 1 < timeSeries.length && end > timeSeries[i + 1]) { //if duration extends to next instance add diff between beginning of both
                length += timeSeries[i + 1] - timeSeries[i];
            }
            else {
                length += end - start;
            }
        }
        return length;
    }
}
