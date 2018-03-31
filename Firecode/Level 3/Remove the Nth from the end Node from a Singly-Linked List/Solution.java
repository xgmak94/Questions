/*
Given a singly-linked list, remove its Nth from the end node.
Examples:
1->2->3->4->5, n=3 ==> 1->2->4->5
1->2->3->4->5, n=1 ==> 1->2->3->4
1->2->3->4->5, n=5 ==> 2->3->4->5
*/

public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null || n < 0)
        return head;

    ListNode curr = head;
    ListNode prev = head;
    int length = 0;
    
    while(curr != null) {
        curr = curr.next;
        length++;
    }
    
    if(length < n) {
        return head;
    }
    else if(length == n) {
        return head.next;
    }
    else {
        curr = head;
        prev = head;
        for(int i = 0 ; i < (length - n) ; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        return head;
    }
}