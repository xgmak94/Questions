/*
Given an array of integers and a target number, determine if it is possible to choose a group of integers from the array, such that the numbers in the group sum to the given target.

Examples:
groupSum({1,2,3,6,5},10) ==> true

groupSum({1,2,3,6,5},18) ==> false


*/

public static boolean groupSum(int[] arr, int target) {
    return groupSum(0,arr,target);
}

/** Helper method to track input array
* @param  start_index   starting index of array
* @param  arr           an array of integers
* @param  target        target sum
* @return boolean       whether target sum can be reached using a subset of arr
*/
public static boolean groupSum(int start_index, int[] arr, int target) {
    // base case: there is no number left. 
    if (start_index >= arr.length)
        return (target == 0);
    else {
        // recursive case 1: include the 1st number, check the remaining
        if (groupSum(start_index+1,arr,target-arr[start_index]))
            return true;
        // recursive case 2: does not include the 1st number, check the remaining
        if (groupSum(start_index+1,arr,target))
            return true;
    }
    return false;
}