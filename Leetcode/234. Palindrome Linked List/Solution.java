/* https://leetcode.com/problems/palindrome-linked-list/

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
*/

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        fast = head; // put one ptr at beginning
        slow = reverseList(slow); // put other ptr at middle and reverse second half of list
        
        while(slow != null) {
            if(slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode temp = prev;
            
            prev = curr;
            curr = curr.next;
            prev.next = temp;
        }
        return prev;
    }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        Queue<ListNode> q = new LinkedList<>();
        
        ListNode curr = head;
        while(curr != null) {
            s.push(curr);
            q.add(curr);
            curr = curr.next;
        }
        
        while(!s.isEmpty() && !q.isEmpty()) {          
            if(s.pop().val != q.remove().val) {
                return false;
            }
        }       
        return true;
    }
}
