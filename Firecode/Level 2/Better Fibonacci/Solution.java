/*
The Fibonacci Sequence is the series of numbers: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ... 
The next number is found by adding up the two numbers before it.

Your goal is to write an optimal method - betterFibonacci that returns the nth Fibonacci number in the sequence. 
n is 0 indexed, which means that in the sequence 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, ..., n == 0 should return 0 and n == 3 should return 2. 
Your method should exhibit a runtime complexity of O(n) and use constant O(1) space. 
With this implementation, your method should be able to compute larger sequences where n > 40.
*/

public static int betterFibonacci(int n) {
    if(n < 2) return n;
        
    int[] memo = new int[n + 1];
    memo[0] = 0;
    memo[1] = 1;
    for(int i = 2 ; i < n + 1 ; i++)
        memo[i] = memo[i - 1] + memo[i - 2];
        
    return memo[n];
}