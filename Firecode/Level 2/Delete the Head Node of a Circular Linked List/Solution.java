/*
Given a circular linked list, implement a method to delete its head node. Return the list's new head node.

*x = indicates head node
1->2->3->4->*1 ==> 2->3->4->*2
*/

public ListNode deleteAtHead(ListNode head) {
    if(head == null || head.next == head) {
        return null;
    }
    head.data = head.next.data;
    head.next = head.next.next;
    return head;
}