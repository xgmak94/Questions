/*
Given a singly-linked list, implement the method that returns Nth node from the end of the list without using extra memory (constant space complexity).
Examples:
1->2->3->4->5->6, n=2 ==> 5
*/

public ListNode findNthNodeFromEnd(ListNode head, int n) {
    int length = 0;
    ListNode iter = head;
    
    while(iter != null) {
        length++;
        iter = iter.next;
    }
    
    if(n > length || n < 0)
        return null;
    
    iter = head;
    for(int i = 0 ; i < (length - n); i++)
        iter = iter.next;  
    return iter;
}