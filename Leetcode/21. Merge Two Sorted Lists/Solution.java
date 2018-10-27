/* https://leetcode.com/problems/merge-two-sorted-lists/description/

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            }
            else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        
        if(l1 != null)
            curr.next = l1;
        if(l2 != null)
            curr.next = l2;
        
        return newHead.next;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        if(l2 == null)
            return l1;
        
        ListNode currA = l1;
        ListNode currB = l2;
        
        ListNode newHead = new ListNode(0);
        ListNode currC = newHead;
        
        while(currA != null && currB != null) {
            if(currA.val > currB.val) {
                currC.next = currB;
                currB = currB.next;
            }
            else {
                currC.next = currA;
                currA = currA.next;
            }
            currC = currC.next;
        }
        
        if(currA != null)
            currC.next = currA;
        if(currB != null)
            currC.next = currB;
        
        return newHead.next;
    }
}

public class Solution {
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