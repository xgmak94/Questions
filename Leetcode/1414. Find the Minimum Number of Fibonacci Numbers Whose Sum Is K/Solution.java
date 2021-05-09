/* https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/

Given the number k, return the minimum number of Fibonacci numbers whose sum is equal to k, whether a Fibonacci number could be used multiple times.

The Fibonacci numbers are defined as:
F1 = 1
F2 = 1
Fn = Fn-1 + Fn-2 , for n > 2.
It is guaranteed that for the given constraints we can always find such fibonacci numbers that sum k.
 
Example 1:
Input: k = 7
Output: 2 
Explanation: The Fibonacci numbers are: 1, 1, 2, 3, 5, 8, 13, ... 
For k = 7 we can use 2 + 5 = 7.

Example 2:
Input: k = 10
Output: 2 
Explanation: For k = 10 we can use 2 + 8 = 10.

Example 3:
Input: k = 19
Output: 3 
Explanation: For k = 19 we can use 1 + 5 + 13 = 19.
*/

class Solution {
    public int findMinFibonacciNumbers(int k) {
        List<Integer> list = new ArrayList<>();
        list.add(1); //f(1)
        list.add(1); //f(2)
        
        int currFib = 1;
        while(list.get(currFib) < k) { //make all fib # up to k
            int nextFib = list.get(currFib) + list.get(currFib-1);
            list.add(nextFib);
            currFib++;
        }
        
        int count = 0;
        while(k > 0) { //keep checking largest fib #
            int n = list.get(currFib);
            if(n <= k) {
                k -= n;
                count++;
            }
            currFib--;
        }
        return count;
    }
}

class Solution {
    public int findMinFibonacciNumbers(int k) {
        int a = 1;
        int b = 1;
        int c = a+b;
        
        while(c < k) {
            a = b;
            b = c;
            c = a+b;
        }
        
        int count = 0;
        while(k > 0) { //keep checking largest fib #
            int n = c;
            if(n <= k) {
                k -= n;
                count++;
            }
            c = b;
            b = a;
            a = c-b;
        }
        return count;
    }
}
