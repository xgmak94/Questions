/* https://leetcode.com/problems/remove-nth-node-from-end-of-list

Given a linked list, remove the nth node from the end of list and return its head.

For example,
Given linked list: 1->2->3->4->5, and n = 2.
After removing the second node from the end, the linked list becomes 1->2->3->5.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = slow;
        
        for(int i = 0 ; i < n ; i++) {
            fast = fast.next;
        }
        
        while(fast != null) {
            fast = fast.next;
            
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return (slow == head) ? head.next : head;
    }
}

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        start.next = head;

        for(int i = 0; i <= n; i++)   {
            fast = fast.next;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
}
