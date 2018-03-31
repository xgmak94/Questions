/*
Given a singly-linked list, implement a method to insert a node at a specific position and return the head of the list.

If the given position is greater than the list size, simply insert the node at the end.

Examples:
Input List: 1->2->3
insertAtPosition(1,4,2) ==> 1->4->2->3
*position=2 means the 2nd node in the list
*/

public ListNode insertAtPosition(ListNode head, int data, int pos) {
    ListNode newNode = new ListNode(data);
    
    if(head == null || pos == 1) {
        newNode.next = head;
        head = newNode;
        return head;
    }
    
    int length = 0;
    ListNode curr = head;
    ListNode prev = curr;
    while(curr != null) {
        length++;
        prev = curr;
        curr = curr.next;
    }
    
    if(pos >= length) {
        prev.next = newNode;
        return head;
    }
    else {
        curr = head;
        for(int i = 1 ; i < pos - 1 ; i++) {
            curr = curr.next;
        }
        newNode.next = curr.next;
        curr.next = newNode;
        return head;
    }

}

public ListNode insertAtPosition(ListNode head, int data, int pos) {
    if (head == null) {
        return new ListNode(data);
    }
    if (pos == 1) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        return newNode;
    }
    head.next = insertAtPosition(head.next, data, pos-1);
    return head;
}