/*
Given a circular-linked list, write a function to delete its tail node and return the modified list's head.
*x = indicates head node
1->2->3->4->*1 ==> 1->2->3->*1
*/

public ListNode deleteAtTail(ListNode head) {
    ListNode temp = head;
    ListNode beforeTail = head;
    while(temp.next != head) {
        beforeTail = temp;
        temp = temp.next;
    }
    beforeTail.next = head;

    return head;
}