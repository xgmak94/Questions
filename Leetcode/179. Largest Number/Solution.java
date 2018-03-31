/* https://leetcode.com/problems/largest-number/description/

Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.

*/

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0)
            return "";
        
        String[] strings = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++) {
            strings[i] = nums[i] + "";
        }
        
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });
        
        if (strings[strings.length-1].charAt(0) == '0') // multiple 0's
            return "0";

        String res = "";
        for(int i = 0 ; i < strings.length ; i++) {
            res = strings[i] + res;
        }
        return res;
    }
}
