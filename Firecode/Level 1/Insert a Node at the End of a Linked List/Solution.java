/*

Write a method to insert a node at the end of a singly-linked list. 
Return the head of the modified list.
Examples:

LinkedList: 1->2 , Head = 1

InsertAtTail(Head,1) ==> 1->2->1
InsertAtTail(Head,2) ==> 1->2->2
InsertAtTail(Head,3) ==> 1->2->3
*/
class ListNode {
	int data;
	ListNode next;        
	ListNode(int data) { 
		this.data = data; 
	}
}  

public ListNode insertAtTail(ListNode head, int data) {
    ListNode insert = new ListNode(data);
    
    ListNode temp = head;
    
    if(temp == null) {
        return insert;
    }
    
    while(temp.next != null) {
        temp = temp.next;
    }
    
    temp.next = insert;
    
    return head;

}