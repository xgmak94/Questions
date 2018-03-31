/* https://leetcode.com/problems/third-maximum-number/description/

Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).

Example 1:
Input: [3, 2, 1]

Output: 1

Explanation: The third maximum is 1.
Example 2:
Input: [1, 2]

Output: 2

Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
Example 3:
Input: [2, 2, 3, 1]

Output: 1

Explanation: Note that the third maximum here means the third maximum distinct number.
Both numbers with value 2 are both considered as second maximum.
*/

class Solution {
    public int thirdMax(int[] nums) {
        Integer first, second, third;
        first = second = third = null;
        
        for(Integer n : nums) {
        	if(n.equals(first) || n.equals(second) || n.equals(third))
        		continue;
            
        	if(first == null || n > first) {
        		third = second;
        		second = first;
        		first = n;
        	}
        	else if(second == null || n > second) {
       			third = second;
        		second = n;
        	}
        	else if(third == null || n > third) {
        		third = n;
        	}
        }
        return (third == null) ? first : third;
    }
}

class Solution {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        int max = Integer.MIN_VALUE;
        for(int n : nums) {
            set.add(n);
            max = (n > max) ? n : max;
        }
        if(set.size() < 3) {
            return set.last();
        }
        else {
            int secondMax = set.lower(max);
            return set.lower(secondMax);
        }
    }
}
