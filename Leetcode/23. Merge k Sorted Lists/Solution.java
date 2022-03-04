/* https://leetcode.com/problems/merge-k-sorted-lists/

Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
*/

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1,ListNode l2){
                return l1.val - l2.val;
            }
        });
        
        ListNode mergedList = new ListNode(0);
        ListNode mergedPtr = mergedList;
        
        for(ListNode list : lists) {
            if(list != null) { //q holds all initial nodes, incase of empty lists
            	q.add(list);
            }
        }
        
        while(!q.isEmpty()) {
            // mergedPtr = mergedPtr.next = q.poll(); equivelent
            mergedPtr.next = q.poll();
            mergedPtr = mergedPtr.next;
            
            if(mergedPtr.next != null) { //add next value of list into queue
            	q.add(mergedPtr.next);
            }
        }
        return mergedList.next;
    }
}
