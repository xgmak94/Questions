/*

Given a singly-linked list, implement the method that returns Nth node from the end of the list. You are allowed to use extra memory for this implementation.
Examples:
1->2->3->4->5->6, n=2 ==> 5

*/

public ListNode findNthNodeFromEnd(ListNode head, int n) {
    if(head == null || n <= 0)
        return null;
    
    HashMap<Integer, ListNode> map = new HashMap<>();
    
    int totalLength = 1;
    ListNode temp = head;
    
    while(temp != null) {
        map.put(totalLength, temp);
        totalLength++; temp = temp.next;
    }

    return (totalLength >= n) ? map.get(totalLength - n) : null;
}