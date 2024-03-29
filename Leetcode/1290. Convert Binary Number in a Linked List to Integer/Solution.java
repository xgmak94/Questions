/* https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

Given head which is a reference node to a singly-linked list.
The value of each node in the linked list is either 0 or 1. 
The linked list holds the binary representation of a number.

Return the decimal value of the number in the linked list.

Example 1:

Input: head = [1,0,1]
Output: 5
Explanation: (101) in base 2 = (5) in base 10

Example 2:
Input: head = [0]
Output: 0

Example 3:
Input: head = [1]
Output: 1

Example 4:
Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880

Example 5:
Input: head = [0,0]
Output: 0
*/

class Solution {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = 2*ans + head.val;
            head = head.next;
        }
        return ans;
    }
}

class Solution {
    public int getDecimalValue(ListNode head) {
    	StringBuilder sb = new StringBuilder();
        while (head != null) {
        	sb.append(head.val);
            head = head.next;
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}
