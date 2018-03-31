/*

Given a Singly-Linked List, write a method - findMiddleNode that finds and returns the middle node of the list in a single pass.

Examples:
1 ==> 1
1->2 ==> 1
1->2->3->4 ==> 2
1->2->3->4->5 ==> 3

*/

public ListNode findMiddleNode(ListNode head) {    
	if(head == null) 
  		return null;
	ListNode slow = head;
	ListNode fast = head;
	while(fast!=null && fast.next != null && (fast.next).next != null  ) {
		slow = slow.next;
		fast = (fast.next).next;
	}
  	return slow;   
}