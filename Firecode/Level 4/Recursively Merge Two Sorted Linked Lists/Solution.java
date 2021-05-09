/*
Given two sorted singly-linked lists, recursively merge them into a new sorted singly-linked list in O(n) runtime. Do not allocate any extra space!
You can assume that both the given lists are already sorted in ascending order.
Examples:
1->2->3->4 + 5->6->7->8 ==> 1->2->3->4->5->6->7->8

1->2->3->4 + 1->2->7->9 ==> 1->1->2->2->3->4->7->9

1->2->3->4 + null ==> 1->2->3->4
*/

public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {    
    ListNode newHead;
    if(l1==null) return l2;
    if(l2==null) return l1;
    if(l1.data <= l2.data) {
        newHead = l1;
        newHead.next = mergeTwoSortedList(l1.next, l2);
    } else {
        newHead = l2;
        newHead.next = mergeTwoSortedList(l2.next, l1);
    }
    return newHead;
}

public ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
    if(l1 == null)
        return l2;
    if(l2 == null)
        return l1;
        
    ListNode newHead = null;
    if(l1.data < l2.data) {
        newHead = l1;
        newHead.next = mergeTwoSortedList(l1.next, l2);
    }
    else {
        newHead = l2;
        newHead.next = mergeTwoSortedList(l1, l2.next);
    }
    return newHead;
}