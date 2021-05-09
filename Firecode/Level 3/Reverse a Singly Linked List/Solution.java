/*
Given the head pointer of a singly linked list, implement a method to reverse the list and return the new head.
Example:
1->2->3 ==> 3->2->1
*/

public ListNode reverseList(ListNode head) {
    if(head == null)
        return null;
        
    Stack<ListNode> s = new Stack<ListNode>();
    
    ListNode iter = head;
    
    while(iter != null) {
        s.push(iter);
        iter = iter.next;
    }
    
    iter = s.pop();
    head = iter;
    
    while(!s.isEmpty()) {
        iter.next = s.pop();
        iter = iter.next;
    }
    
    iter.next = null;
    
    return head;
}