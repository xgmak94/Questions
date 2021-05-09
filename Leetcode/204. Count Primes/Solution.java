/* https://leetcode.com/problems/count-primes

Count the number of prime numbers less than a non-negative number, n.
*/

class Solution {
    public int countPrimes(int n) {
        boolean[] prime = new boolean[n];
        int count = 0;

        for(int i = 0 ; i < n ; i++) {
            prime[i] = true;
        }
        
        for(int i = 2 ; i < Math.sqrt(n) ; i++) {
            for(int j = 2 ; i * j < n ; j++) {
                prime[i*j] = false;
            }
        }
        
        for(int i = 2 ; i < n ; i++) { //0, 1 are not prime
            if(prime[i] == true) {
                count++;
            }
        }
        return count;
    }
}