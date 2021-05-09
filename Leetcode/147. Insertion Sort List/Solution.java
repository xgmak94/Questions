/* https://leetcode.com/problems/insertion-sort-list/

Sort a linked list using insertion sort.
*/

class Solution {
    public ListNode insertionSortList(ListNode head) {
    	if(head == null || head.next == null) return head;

        ListNode sorted = new ListNode(0);
        ListNode curr = head;
        while(curr != null) {
        	ListNode next = curr.next; //next element to insert
            ListNode sortedIter = sorted;

            while(sortedIter.next != null && sortedIter.next.val < curr.val) { //find correct position
                sortedIter = sortedIter.next;
            }
        	curr.next = sortedIter.next;
        	sortedIter.next = curr;
        	curr = next;
        }
        return sorted.next;
    }  
}
