/* 

Question:
You are on a flight and wanna watch two movies during this flight.
You are given List<Integer> movieDurations which includes all the movie durations.
You are also given the duration of the flight which is d in minutes.
Now, you need to pick two movies and the total duration of the two movies is less than or equal to (d - 30min).

Find the pair of movies with the longest total duration and return they indexes. If multiple found, return the pair with the longest movie.

Example 1:

Input: movieDurations = [90, 85, 75, 60, 120, 150, 125], d = 250
Output: [0, 6]
Explanation: movieDurations[0] + movieDurations[6] = 90 + 125 = 215 is the maximum number within 220 (250min - 30min)

*/

public class Solution {
    public static int[] moviesOnFlight(int[] movieDurations, int d) {
        int[] ret = new int[2];
        ret[0] = 0;
        ret[1] = 0;
        Arrays.sort(movieDurations);
        
        int max = 0;
        int l = 0;
        int r = movieDurations.length-1;
        
        while(l < r) {
            int sum = movieDurations[l] + movieDurations[r];
            if(sum > max && sum <= d-30) {
                max = sum;
                ret[0] = movieDurations[l];
                ret[1] = movieDurations[r];
            }
            else if (sum > d-30)
                r--;
            else
                l++;
        }        
        return ret;
    } 
    public static void main(String[] args) {
        int[] movieDurations = {90, 85, 75, 60, 120, 150, 125};
        int d = 250;
        
        int[] ret = moviesOnFlight(movieDurations, d);
        System.out.printf("%d, %d\n", ret[0], ret[1]);
    }
}
