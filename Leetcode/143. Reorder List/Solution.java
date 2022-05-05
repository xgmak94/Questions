/* https://leetcode.com/problems/reorder-list/

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Example 1:
Input: head = [1,2,3,4]
Output: [1,4,2,3]

Example 2:
Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]

Constraints:
The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
*/

//reversing second half of list
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //second half of list starts at slow.next
        ListNode secondHalf = slow.next;
        secondHalf = reverseList(secondHalf);
        slow.next = null; //cut off half of list
        
        ListNode firstHalf = head;
        while(firstHalf != null && secondHalf != null) {
            ListNode firstNext = firstHalf.next;
            ListNode secondNext = secondHalf.next;
            
            firstHalf.next = secondHalf;
            secondHalf.next = firstNext;
            
            firstHalf = firstNext;
            secondHalf = secondNext;
        }
    }
    
    //reverses list and returns new head
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}

//using a stack
class Solution {
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //second half of list starts at slow.next
        ListNode secondHalf = slow.next;
        slow.next = null; //cut off half of list
        while(secondHalf != null) {
            stack.push(secondHalf);
            secondHalf = secondHalf.next;
        }
        
        ListNode curr = head;
        while(!stack.isEmpty()) {
            ListNode next = curr.next;
            curr.next = stack.pop();
            curr.next.next = next;
            curr = next;
        }
    }
}
