/* https://leetcode.com/problems/add-two-numbers-ii
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> num1 = new Stack<>();
        Stack<ListNode> num2 = new Stack<>();
        
        ListNode curr1 = l1; ListNode curr2 = l2;
        
        while(curr1 != null) {
            num1.push(curr1);
            curr1 = curr1.next;
        }
        while(curr2 != null) {
            num2.push(curr2);
            curr2 = curr2.next;
        }

        ListNode list = null; ListNode curr = null;
        
        int sum = 0;
        while(!num1.isEmpty() || !num2.isEmpty()) {
            if(!num1.isEmpty()) sum += num1.pop().val;
            if(!num2.isEmpty()) sum += num2.pop().val;
            
            curr = new ListNode(sum % 10);
            curr.next = list;
            list = curr;
            
            if(sum >= 10)
                sum = 1;
            else
                sum = 0;
            // sum = (sum > 9) ? 1 : 0;
        }
        
        if(sum == 1) {
            curr = new ListNode(sum);
            curr.next = list;
        }
        return curr;
    }
}
