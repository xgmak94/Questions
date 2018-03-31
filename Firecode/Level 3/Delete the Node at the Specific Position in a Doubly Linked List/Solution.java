/*
Given a doubly-linked list, write a method to delete the node at a given position (starting from 1 as the head position) and return the modified list's head. Do nothing if the input position is out of range.

Examples:
1<=>2<=>3<=>4, pos=6 ==> 1<=>2<=>3<=>4
1<=>2<=>3<=>4, pos=3 ==> 1<=>2<=>4
*/

// java.util.* has been imported for this problem.
// You don't need any other imports.

public DoublyLinkedNode deleteAtPos(DoublyLinkedNode head, int pos) {
    if(head == null || pos < 1) {
        return head;
    }
    else if(pos == 1) { // head
        return (head.next == null) ? null : head.next;
    }
    else {
        int length = 1;
        DoublyLinkedNode curr = head;
        DoublyLinkedNode previous = head;
        
        while(curr != null && length != pos) {
            previous = curr;
            curr = curr.next;
            length++;
        }
        
        if(length < pos || pos > length) {
            return head;
        }
        else if(curr.next == null) { // tail
            curr.prev.next = null;
            return head;
        }
        else { // middle
            curr.prev.next = curr.next;
            curr.next.prev = prev;
            return head;
        }
    }
}