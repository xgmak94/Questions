/*
Given a singly-linked list, check whether its length is even or odd in a single pass. 
An Empty list has 0 nodes which makes the number of nodes in it even.
Examples:
1->2->3->4 == true 1->2->3->4->5 == false
*/

public Boolean isListEven(ListNode head) {
    // Add your code below this line. Do not modify any other code.    
    boolean even = true;
    ListNode temp = head;
    while(temp != null) {
        even = !even;
        temp = temp.next;
    }
    
    return even;
}