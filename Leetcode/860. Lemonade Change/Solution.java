/* https://leetcode.com/problems/lemonade-change/

At a lemonade stand, each lemonade costs $5. 

Customers are standing in a queue to buy from you, and order one at a time (in the order specified by bills).

Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.  
You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Return true if and only if you can provide every customer with correct change.
*/

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        for(int bill : bills) {
            if(bill == 5) {
                five++;
            }
            else if(bill == 10) {
                ten++;
                five--;
            }
            else if(bill == 20) {
                if(ten > 0) {
                    ten--;
                    five--;
                }
                else {
                    five -= 3;
                }
            }
            
            if(five < 0 || ten < 0) return false;
        }
        return true;
    }
}

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[2]; //5, 10 bills 20 does not matter
        for(int i = 0 ; i < bills.length ; i++) {
            if(bills[i] == 5) { //don't need change
                change[0]++;
            }
            else if(bills[i] == 10) { //can only give back a 5
                if(change[0] >= 1) { //if we have a 5
                    change[0]--;
                    change[1]++;
                }
                else { //no change
                    return false;
                }
            }
            else if(bills[i] == 20) { //can give back 10+5 or 5+5+5, PRIORITY 10+5
                if(change[1] >= 1 && change[0] >= 1) { //if we have a 10 and 5
                    change[0]--;
                    change[1]--;
                }
                else if(change[0] >= 3) { //if we have 3 5's
                    change[0] -= 3;
                }
                else {
                    return false;
                }
            }   
        }
        return true;
    }
}
