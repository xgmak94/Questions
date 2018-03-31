/*

Write a method to compute the binary representation of a positive integer. 
The method should return a string with 1s and 0s. 

computeBinary(6) ==> "110"
computeBinary(5) ==> "101"

Note: Use the minimum number of binary digits needed for the representation (Truncate unnecessary trailing 0s).
computeBinary(5) ==> "0101" (incorrect)
computeBinary(5) ==> "101" (correct)

*/

public static String computeBinary(int val) {
    // Base case: value is less than 2
    if (val < 2)
      return Integer.toString(val);
    // Recursive case: binary rep = binary of the header + last digit (odd/even)
    else {
      return computeBinary(val/2)+computeBinary(val%2);
    }
  }