/*
Given a singly-linked list, remove duplicates in the list and return head of the list. Target a worst case space complexity of O(n).
Examples:
1->2->2->4->3->1 ==> 1->2->4->3
1 ==> 1
"" ==> ""
*/

public ListNode removeDuplicates(ListNode head) {
    if(head == null || head.next == null)
        return head;
        
    HashMap<Integer, ListNode> map = new HashMap<>();
    
    ListNode curr = head;
    ListNode prev = curr;
    while(curr != null) {
        if(map.get(curr.data) == null) {
            map.put(curr.data, curr);
            prev = curr;
        }
        else {
            prev.next = curr.next;
        }
        curr = curr.next;
    }
    return head;
}