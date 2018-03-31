/* https://leetcode.com/problems/add-two-numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
        ListNode currA = l1;
        ListNode currB = l2;

        int sum = 0;

        ListNode newHead = new ListNode(0);
        ListNode currC = newHead;

        while(currA != null || currB != null) {
            sum /= 10;
            if(currA != null) {
                sum += currA.val;
                currA = currA.next;
            }
            if(currB != null) {
                sum += currB.val;
                currB = currB.next;
            }
            
            currC.next = new ListNode(sum % 10);
            
            currC = currC.next;
        }
        
        if(sum >= 10)
            currC.next = new ListNode(1);
        
        return newHead.next;
    }
}

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1.val == 0 && l1.next == null)
            return l2;
        if(l2.val == 0 && l2.next == null)
            return l1;

        ListNode newHead = new listNode(0);
        ListNode currA = l1; ListNode currB = l2; ListNode currC = newHead;

        int carry = 0;

        while(currA != null || currB != null) {
            int c = carry;
            if(currA != null) {
                c += currA.val;
                currA = currA.next;
            }
            if(currB != null) {
                c += currB.val;
                currB = currB.next;
            }
            
            carry = (c >= 10) ? 1 : 0;
            c = (c >= 10) ? c - 10 : c;

            currC.next = new ListNode(c);
            currC = currC.next;
        }

        // if(carry)
        //     currC.next = new ListNode(1);
        // else
        //     currC.next = null;
        currC.next = (carry == 1) ? new ListNode(1) : null;

        return newHead.next;     
    }
}
