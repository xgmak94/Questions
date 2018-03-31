/*
Given two integers represented as linked-lists, find their sum and return it in the form of linked list.

Note: You can assume that the input integers are non negative and the digits stored in the linked lists are in the reverse order. Take a look at the examples to understand the format.

Example:
Input 1: 1->2->3
Input 2: 1->2->3  
Output : 2->4->6 

Input 1: 9->9
Input 2: 9->8 
Output : 8->8->1

*/

public static ListNode sumTwoLinkedLists(ListNode input1, ListNode input2) {
    ListNode currA = input1;
    ListNode currB = input2;
    
    int carry = 0;
    
    ListNode newHead = new ListNode(0);
    ListNode currC = newHead;
    
    while(currA != null && currB != null) {
        int c = currA.data + currB.data + carry;
     
        carry = (c >= 10) ? 1 : 0;
        c = (c >= 10) ? c - 10 : c;
        
        currC.next = new ListNode(c);
        
        currA = currA.next;
        currB = currB.next;
        currC = currC.next;
    }
    
    currC.next = (carry == 1) ? new ListNode(-1) : null;
    
    return newHead.next;     
}