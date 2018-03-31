/* https://leetcode.com/problems/count-primes	
Count the number of prime numbers less than a non-negative number, n.
*/


public class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        for(int i = 0 ; i < n ; i++)
            prime[i] = true;
        
        for(int i = 2 ; i < Math.sqrt(n) ; i++) {
            for(int j = 2 ; i * j < n ; j++)
                prime[i*j] = false;
        }
        
        int count = 0;
        for(int i = 2 ; i < n ; i++) {
            if(prime[i] == true)
                count++;
        }
        return count;
    }
}
