/*
Write a method to merge k Sorted Linked Lists. Why would you ever want to do that? Well, if you're dealing with a list of over 200 Million Integers that needs to be sorted, an efficient approach might involve splitting up the massive list into k smaller lists, sorting each list in memory and then combining the sorted lists to re-create the original list, albeit sorted. 

Example:
Inputs Lists : 
LinkedList1: 1->2->13->20
LinkedList2: 1->20->35->40
LinkedList3: 5->6->12->18

Output List: 
LinkedList: 1->1->2->5->6->12->13->18->20->20->35->40

Note: 
mergeKLists takes in an ArrayList of ListNodes - lists, where each ListNode is the head of a custom Linked List structure.
*/

public ListNode mergeKLists(ArrayList<ListNode> lists) {
    PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.size(),
        new Comparator<ListNode>() {
          public int compare(ListNode node1, ListNode node2) {
           if (node1.data > node2.data)
              return 1;
            else if(node1.data == node2.data)
              return 0;
            else 
              return -1;
          }});
    
    for(ListNode list : lists) {
        q.add(list);
    }
    
    ListNode head = new ListNode(0);
    ListNode curr = head;
    
    while(!q.isEmpty()) {
        ListNode front = q.poll();
        curr.next = front;
        
        if(front.next != null)
            q.add(front.next);
        
        curr = curr.next;
    }
    return head.next;
}