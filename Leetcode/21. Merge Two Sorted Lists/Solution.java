/* https://leetcode.com/problems/merge-two-sorted-lists/

Merge two sorted linked lists and return it as a new list. 
The new list should be made by splicing together the nodes of the first two lists.
*/

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {   
        ListNode merged = new ListNode(0);
        ListNode mergedptr = merged;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                mergedptr.next = l1;
                l1 = l1.next;
                mergedptr = mergedptr.next;
            }
            else{
                mergedptr.next = l2;
                l2 = l2.next;
                mergedptr = mergedptr.next;
            }
        }
        if(l1 != null) mergedptr.next = l1; //get the rest
        if(l2 != null) mergedptr.next = l2; //get the rest

        return merged.next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}