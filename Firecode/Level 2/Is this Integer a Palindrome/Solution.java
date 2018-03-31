/*
Write a method that checks if a given integer is a palindrome - without allocating additional heap space
Examples:
-1 ==> false
0 ==> true
1221 ==> true
*/

public static Boolean isIntPalindrome(int x) {            
	int num = x;
	//reversing number
	int reverse = 0,remainder; 
	while(num > 0) { 
	 remainder = num % 10; 
	 reverse = reverse * 10 + remainder; 
	 num = num / 10; 
	} 
	return (reverse == x);
}