/*

Given an integer array containing the available denominations of coins in descending order, write a method to compute the number of possible ways of representing a monetary amount in cents. 
 For simplicity, assume that there are an infinite number of coins available for each coin denomination in the array. 

Examples:

makeChange({25,10,5,1},10) ==> 4

*/

public static int makeChange(int[] coins, int amount) {    
    if (coins != null && coins.length > 0 && amount >= 0)
      return makeChange(coins,amount,0);
    return 0;
  }

  public static int makeChange(int[] coins, int amount, int current_coin_index) {
    int next_coin_index;
    if (current_coin_index < coins.length - 1){
      //If the coin index is less than the last index, increment the index.
      next_coin_index = current_coin_index + 1;
    }
    else
    {
      //If the current coin index is equal to the last index, return the coin itself.  
      return coins[current_coin_index];
    }
    int res = 0;
    //Logic to calculate the residual amount.
    for (int i = 0; i * coins[current_coin_index] <= amount; i++) {
      res += makeChange(coins,amount-i*coins[current_coin_index],next_coin_index);
    }
    return res;
  }