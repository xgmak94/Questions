/* https://leetcode.com/problems/self-dividing-numbers

A self-dividing number is a number that is divisible by every digit it contains.

For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.

Also, a self-dividing number is not allowed to contain the digit zero.

Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.

Example 1:
Input: 
left = 1, right = 22
Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
*/

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left ; i <= right ; i++) {
            if(selfDividing(i)) list.add(i);
        }
        return list;
    }
    
    public boolean selfDividing(int n) {
        List<Integer> list = getDigits(n);
        for(int digit : list) {
            if(digit == 0 || n % digit != 0) return false;
        }
        return true;
    }
    
    public List<Integer> getDigits(int n) {
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        return list;
    }
}

class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for(int i = left ; i <= right ; i++) {
            int j = i;
            while(j > 0) {
                if(j % 10 == 0 || i % (j % 10) != 0) {
                    break;
                }
                j = j / 10;
            }
            if(j == 0)
                list.add(i);
        }
        return list;
    }
}
