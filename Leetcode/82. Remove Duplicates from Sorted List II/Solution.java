/* https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode curr = newHead.next;

        while(curr != null) {
            while(curr.next != null && curr.val == curr.next.val) { //curr loops to end of the same vals
                curr = curr.next;
            }
            
            if(prev.next == curr) {
                prev = curr;
            }
            else {
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return newHead.next;
    }
}
