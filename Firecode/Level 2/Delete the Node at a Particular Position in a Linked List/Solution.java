/*

Given a singly-linked list, implement a method to delete the node at a given position (starting from 1 as the head position) and return the head of the list. 
Do nothing if the input position is out of range.

Examples:

LinkedList: 1->2->3->4 , Head = 1

deleteAtMiddle(Head,3) ==> 1->2->4
*/

public ListNode deleteAtMiddle(ListNode head, int position) {
    if(position == 1) {
        return (head == null) ? null : head.next;
    }

    ListNode curr = head;
    ListNode prev = head;
    
    int count = 0;
    
    while(curr != null) {
        count++;
        if(count == position) {
            prev.next = curr.next;
            curr.next = null;
        }
        else {
            prev = curr;
            curr = curr.next;
        }
    }
    return head;
}