/*
Given a circular linked list, write a method to insert a node at its tail. Return the list's head.

Examples:

*x = indicates head node
Insert 1 ==> *1
Insert 2 ==> 1->2->*1
Insert 3 ==> 1->2->3->*1
*/

public ListNode insertAtTail(ListNode head, int data) {
    ListNode newNode = new ListNode(data);
    if(head == null) {
        newNode.next = newNode;
        return newNode;
    }
    
    ListNode curr = head;
    while(curr.next != head) {
        curr = curr.next;
    }
    
    curr.next = newNode;
    newNode.next = head;
    return head;
}