/* https://leetcode.com/problems/linked-list-cycle

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

*/

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
