/* https://leetcode.com/problems/reverse-linked-list/description/

Reverse a singly linked list.

*/

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode nextNode= curr.next;
            
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}
