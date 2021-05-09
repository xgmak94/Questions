/* https://leetcode.com/problems/remove-linked-list-elements

Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
*/

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(0);
        ListNode ptr = newHead;
        
        while(head != null) {
            if(head.val == val) {
                head = head.next;
            }
            else {
                ptr.next = head;
                ptr = ptr.next;
                head = head.next;
            }
        }
        ptr.next = null;
        return newHead.next;
    }
}

class Solution {
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
