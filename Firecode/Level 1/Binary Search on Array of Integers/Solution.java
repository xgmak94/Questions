/*
Write a method that searches an Array of integers for a given integer using the Binary Search Algorithm. 
If the input integer is found in the array, return true. 
Otherwise, return false.
You can assume that the given array of integers is already sorted in ascending order.

Examples:

binarySearch({2,5,7,8,9},9) -> true

binarySearch({2,8,9,12},6) -> false

binarySearch({2},4) -> false

binarySearch({},9) -> false

{} -> [Empty] Array 
*/

public static Boolean binarySearch(int[] arr, int n){
    // Think about maintaining the boundaries of your array with a lo
    // index and a hi index. lo=0; hi=length - 1;
    int lo = 0;
    int hi = arr.length - 1;
    // Use a while loop to iterate until lo <= hi. The moment that lo exceeds
    // hi, we can be sure that the entire array has been searched. 
    while(lo <= hi){
        // Create a mid index. int mid = lo + (hi-lo)/2;
        int mid = lo + (hi-lo)/2;
        // If arr[mid] < n, set lo = mid+1 to divide the array
        if(arr[mid] < n) lo = mid+1;
        // Else If arr[mid] > n, set hi = mid - 1 to divide the array
        else if(arr[mid] > n) hi = mid-1;
        // Otherwise, return true!
        else return true;
    }
    return false;
}