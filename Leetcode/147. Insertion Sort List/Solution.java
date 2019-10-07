/* https://leetcode.com/problems/insertion-sort-list/
Sort a linked list using insertion sort.
*/


public class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null)
    		return head;

        ListNode sorted = new ListNode(0);
        ListNode sortedIter = sorted;

        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null) {
        	next = curr.next;

            while(sortedIter.next != null && sortedIter.next.val < curr.val)
                sortedIter = sortedIter.next;
        	curr.next = sortedIter.next;
        	sortedIter.next = curr;
        	sortedIter = sorted;

        	curr = next;
        }
        return sorted.next;
    }  
}
