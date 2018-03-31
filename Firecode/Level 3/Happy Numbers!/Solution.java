/*
Write a method to determine whether a postive number is Happy.
A number is Happy (Yes, it is a thing!) if it follows a sequence that ends in 1 after following the steps given below : 
Beginning with the number itself, replace it by the sum of the squares of its digits until either the number becomes 1 or loops endlessly in a cycle that does not include 1.

For instance, 19 is a happy number. Sequence:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1

Example:

Input : 19 
Output: true 
*/

public static boolean isHappyNumber(int n) {
    int [] digitArray = getInputDigits(n);
    int sum;
    
    do{
      sum = 0;
      for(int i=0;i<digitArray.length;i++)
      {
       sum = sum + digitArray[i]*digitArray[i]; 
      }
      digitArray = getInputDigits(sum);
    }while(sum >9);
    
    if(sum == 1)
      return true;
    
    return false;
  }
   
  public static int[] getInputDigits(int n){
      String s = String.valueOf(n);
      int[] digits = new int[s.length()];
      int i=0;
   
      while(n>0){
          int m = n%10;
          digits[i++] = m;
          n = n/10;
      }
      return digits;
  }