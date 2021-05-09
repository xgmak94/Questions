/* https://leetcode.com/problems/partition-list

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0);
        ListNode ptr1 = less;
        
        ListNode greater = new ListNode(0);
        ListNode ptr2 = greater;
            
        while(head != null) {
            if(head.val < x) {
                ptr1.next = head;
                ptr1 = ptr1.next;
            }
            else{
                ptr2.next = head;
                ptr2 = ptr2.next;
            }
            head = head.next;
        }
        ptr2.next = null;
        ptr1.next = greater.next;
        
        return less.next;
    }
}
