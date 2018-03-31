/*

Write a method to insert a node at the front of a singly-linked list and return the head of the modified list.
Examples:

LinkedList: 1->2 , Head = 1

InsertAtHead(Head,1) ==> 1->1->2
InsertAtHead(Head,2) ==> 2->1->2
InsertAtHead(Head,3) ==> 3->1->2

*/

class ListNode {
    int data;
    ListNode next;        
    ListNode(int data) { this.data = data; }
 }  

public ListNode insertAtHead(ListNode head, int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        return newNode;
}