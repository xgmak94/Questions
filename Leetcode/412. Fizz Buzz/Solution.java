/* https://leetcode.com/problems/fizz-buzz

Write a program that outputs the string representation of numbers from 1 to n.
But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. 
For numbers which are multiples of both three and five output “FizzBuzz”.
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>(n);
        for(int i = 1 ; i <= n ; i++) {
            if(i % 3 == 0 && i % 5 == 0) {
                list.add("FizzBuzz");
            }
            else if(i % 3 == 0) {
                list.add("Fizz");
            }
            else if(i % 5 == 0) {
                list.add("Buzz");
            }
            else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
