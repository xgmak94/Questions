/* https://leetcode.com/problems/partition-list/description/

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

*/

/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode node1 = new ListNode(0);
        ListNode ptr1 = node1;
        
        ListNode node2 = new ListNode(0);
        ListNode ptr2 = node2;
            
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
        ptr1.next = node2.next;
        
        return node1.next;
    }
}