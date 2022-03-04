/* https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/

Given two integers tomatoSlices and cheeseSlices.
The ingredients of different burgers are as follows:
Jumbo Burger: 4 tomato slices and 1 cheese slice.
Small Burger: 2 Tomato slices and 1 cheese slice.

Return [total_jumbo, total_small] so that the number of remaining tomatoSlices equal to 0 and the number of remaining cheeseSlices equal to 0.
If it is not possible to make the remaining tomatoSlices and cheeseSlices equal to 0 return [].
*/

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ret = new ArrayList<>();
        //jumbo + small = cheeseSlices
        //4jumbo + 2small = tomatoSlices
        
        //jumbo = cheeseSlices - small
        //4(cheeseSlices - small) + 2small = tomatoSlices
        //4cheeseSlices - 2small = tomatoSlices
        //small = 2cheeseSlices - tomatoSlices/2
        
        //jumbo + (2cheeseSlices - tomatoSLices/2) = cheeseSlices
        //jumbo = tomatoSlices/2 - cheeseSlices
        
        int jumbo = tomatoSlices/2 - cheeseSlices;
        int small = 2*cheeseSlices - tomatoSlices/2;
        if(4*jumbo + 2*small == tomatoSlices && jumbo + small == cheeseSlices && jumbo >= 0 && small >= 0) {
            ret.add(tomatoSlices/2 - cheeseSlices);
            ret.add(2*cheeseSlices - tomatoSlices/2);
        }
        return ret;
    }
}