/*
Given an Array of integers, write a method that will return the integer with the maximum number of repetitions. 
Your code is expected to run with O(n) time complexity and O(1) space complexity. 
The elements in the array are between 0 to size(array) - 1 and the array will not be empty.

f({3,1,2,2,3,4,4,4}) --> 4
*/

public static int getMaxRepetition(int[] a) {
    int max = a.length; 
      // Iterate though input array, for every element a[i],
      // increment a[a[i]%k] by k
      for (int i = 0; i< a.length; i++)
          {  
            a[a[i]%max] += max;
          }
      // Find index of the maximum repeating element
      int maxr = a[0], result = 0;
      for (int i = 1; i < a.length; i++)
      {
          if (a[i] > maxr)
          {
              maxr = a[i];
              result = i;
          }
      }
      return result;
}