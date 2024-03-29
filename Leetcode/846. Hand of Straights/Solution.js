/* https://leetcode.com/problems/hand-of-straights/

Alice has some number of cards and she wants to rearrange the cards into groups so that each group is of size groupSize, and consists of groupSize consecutive cards.

Given an integer array hand where hand[i] is the value written on the ith card and an integer groupSize, return true if she can rearrange the cards, or false otherwise.

Example 1:
Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
Output: true
Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]

Example 2:
Input: hand = [1,2,3,4,5], groupSize = 4
Output: false
Explanation: Alice's hand can not be rearranged into groups of 4.

Constraints:
1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length
 

Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
*/

/**
 * @param {number[]} hand
 * @param {number} groupSize
 * @return {boolean}
 */
var isNStraightHand = function(hand, groupSize) {
    hand.sort((a,b) => a-b);
    let map = new Map();
    
    for(let num of hand) {
        if(!map.has(num)) {
            map.set(num, 0);
        }
        map.set(num, map.get(num) + 1);
    }
    
    for(let num of hand) {
        let freq = map.get(num);
        if(freq > 0) {
            for(let i = 1 ; i < groupSize ; i++) {
                if(map.get(num + i) && map.get(num + i) > 0) {
                    freq = Math.min(freq, map.get(num + i));
                }
                else {
                    return false;
                }
            }
            for(let i = 0 ; i < groupSize ; i++) {
                map.set(num + i, map.get(num + i) - freq);
            }
        }
    }
    return true;
};
