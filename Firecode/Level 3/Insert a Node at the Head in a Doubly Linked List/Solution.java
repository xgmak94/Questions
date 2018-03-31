/*
Given a doubly linked list, implement a method to insert a node at its head. Return the head of the list.

Examples:
Insert 1 ==> 1
Insert 2 ==> 2<=>1
Insert 3 ==> 3<=>2<=>1
*/

public DoublyLinkedNode insertAtHead(DoublyLinkedNode head, int data) {
    DoublyLinkedNode newNode = new DoublyLinkedNode(data);                
    newNode.prev = null;
    newNode.next = head;
    
    if(head == null) {
        return newNode;
    }
    else {
        head.prev = newNode;
        return newNode;
    }
    
}