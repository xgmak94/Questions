/* https://leetcode.com/problems/linked-list-cycle-ii/

Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

*/

class Solution {
    public ListNode detectCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        
        ListNode curr = head;
        while(curr != null) {
            if(set.add(curr)) { //true if can be added to set
                curr = curr.next;
            }
            else { //cannot be added to set already exists, cycle
                return curr;
            }
        }
        return null;
    }
}
