/* https://leetcode.com/problems/add-strings/

Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        
        int carry = 0;
        for(int i = num1.length()-1, j = num2.length()-1 ; i >= 0 || j >= 0 ; i--, j--) { //i>= 0 || j>=0 to keep going until done with both
            int a = (i >= 0) ? num1.charAt(i) - '0' : 0; //adding 0's once we reach the end of the shorter num
            int b = (j >= 0) ? num2.charAt(j) - '0' : 0;
            sb.append((a+b+carry) % 10);
            carry = (a+b+carry) / 10;
        }
        if(carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

class Solution {
	public String addStrings(String num1, String num2) {
		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int i = num1.length()-1;
		int j = num2.length()-1;

		while(i >= 0 || j >= 0) {
			int a = (i >= 0) ? num1.charAt(i) - '0' : 0;
			int b = (j >= 0) ? num2.charAt(j) - '0' : 0;
			sb.append((a+b+carry) % 10);
			carry = (a+b+carry) / 10;
            i--;
            j--;
		}
		if(carry != 0) sb.append(carry);
		return sb.reverse().toString();
	}
}
