/* https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
Return True if its possible otherwise return False.

Example 1:
Input: nums = [1,2,3,3,4,4,5,6], k = 4
Output: true
Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].

Example 2:
Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
Output: true
Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].

Example 3:
Input: nums = [3,3,2,2,1,1], k = 3
Output: true
*/

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var isPossibleDivide = function(nums, k) {
    nums.sort((a,b) => a-b);
    let map = new Map();
    
    for(let num of nums) {
        if(!map.has(num)) {
            map.set(num, 0);
        }
        map.set(num, map.get(num) + 1);
    }
    
    for(let num of nums) {
        let freq = map.get(num);
        if(freq > 0) {
            for(let i = 1 ; i < k ; i++) {
                if(map.get(num + i) && map.get(num + i) > 0) {
                    freq = Math.min(freq, map.get(num + i));
                }
                else {
                    return false;
                }
            }
            for(let i = 0 ; i < k ; i++) {
                map.set(num + i, map.get(num + i) - freq);
            }
        }
    }
    return true;
};
