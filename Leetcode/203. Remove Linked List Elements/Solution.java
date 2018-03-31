/* https://leetcode.com/problems/remove-linked-list-elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;
        
        while(head != null) {
            if(head.val != val) {
                ptr.next = head;
                ptr = ptr.next;
                
                head = head.next;
                ptr.next = null;
            }
            else {
                head = head.next;
            }
        }
        return newHead.next;
    }
}

public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) 
            return null;
        
        ListNode next = removeElements(head.next, val);
        
        if(head.val == val) {
            return next;
        }
        else {
            head.next = next;
            return head;
        }
    }
}
