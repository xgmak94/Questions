/*

Given an array of integers and a target integer, write a method groupSumWithNum to determine if it is possible to choose a group of integers from the array such that the group sums to the given target. An additional constraint is that the summation must include the integer must_have if it is present in the array.

Examples:
groupSumWithNum({1,2,3,6,5},5,10) ==> true

groupSumWithNum({1,2,3,6,5},3,7) ==> false

*/

public static boolean groupSumWithNum(int[] arr, int must_have, int target) {
        return groupSumWithNum(0,arr,must_have,target);
}

// helper method
public static boolean groupSumWithNum(int start_index, int[] arr, int must_have, int target) { 
    if (start_index >= arr.length) {        // base case: there is no number left.
    return (target == 0);
  }
  else {
    // recursive case 0: include if must have, check the remaining
    if (arr[start_index]==must_have) 
      return groupSumWithNum(start_index+1,arr,must_have,target-must_have);
    else {
      // recursive case 1: include the 1st number, check the remaining
      if (groupSumWithNum(start_index+1,arr,must_have,target-arr[start_index]))
        return true;
      // recursive case 2: does not include the 1st number, check the remaining
      if (groupSumWithNum(start_index+1,arr,must_have,target))
        return true;
    }
  }
  return false;
}