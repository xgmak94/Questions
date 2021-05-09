/*

Given an Array containing 9 numbers ranging from 1 to 10, write a method to find the missing number. 
Assume you have 9 numbers between 1 to 10 and only one number is missing.

findMissingNumber({1,2,4,5,6,7,8,9,10}) --> 3

*/

public static int findMissingNumber(int[] arr) {
    int expectSum = 0;
    for(int i = 1 ; i <= arr.length + 1 ; i++)
        expectSum += i;
    
    int arraySum = 0;
    for(int i = 0 ; i < arr.length ; i++)
        arraySum += arr[i];
    
    return expectSum - arraySum;
}