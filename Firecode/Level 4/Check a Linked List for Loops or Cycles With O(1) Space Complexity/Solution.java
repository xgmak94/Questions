/*

Check if a given linked list has cycles. Try to achieve O(n) runtime with a space complexity of O(1). If there is a cycle, return true otherwise return false. Consider empty lists as non cyclic.
Examples:
1->2->3->4->1 ==> true
1->2->3->4 ==> false

*/

public Boolean isCyclic(ListNode head) {
    if(head == null || head.next == null)
        return false;
        
    ListNode slow = head;
    ListNode fast = head.next;

    while(fast.next != null && fast.next.next != null) {
        if(fast == slow)
            return true;
            
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}