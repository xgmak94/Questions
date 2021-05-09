/* https://leetcode.com/problems/remove-duplicates-from-sorted-list

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
*/

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) 
            return head;
        ListNode first = head;
        ListNode next = first.next;
        
        while(next != null) {
            if(first.val == next.val) {
                next = next.next;
            }
            else {
                first.next = next;
                first = next;
                next = next.next;
            }
        }
        first.next = null;
        return head;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head.next;
        ListNode prev = head;
        
        while(curr != null) {
            if(curr.val == prev.val) {
                curr = curr.next;
                prev.next = null;
            }
            else {
                prev.next = curr;
                prev = prev.next;
                curr = curr.next;
            }
        }
        return head;
    }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        
        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val)
                curr.next = curr.next.next;
            else
                curr = curr.next;
        }
        return head;
    }
}
