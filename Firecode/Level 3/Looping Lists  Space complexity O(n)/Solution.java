/*
Given a singly-linked list, implement a method to check if the list has cycles. The space complexity can be O(n). If there is a cycle, return true otherwise return false. Empty lists should be considered non-cyclic.
Examples:
1->2->3->4->1 ==> true
1->2->3->4 ==> false

*/


public Boolean isCyclic(ListNode head) {
    HashMap<Integer, ListNode> map = new HashMap<>();
        
    ListNode curr = head;
    while(curr != null) {
        if(map.containsKey(curr.data))
            return true;
        else
            map.put(curr.data, curr);
        curr = curr.next;
    }
    return false;
}