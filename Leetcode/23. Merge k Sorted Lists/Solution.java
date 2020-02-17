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

*

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
            @Override
            public int compare(ListNode l1,ListNode l2){
                if(l1.val < l2.val) 
                	return -1;
                else if(l1.val > l2.val) 
                	return 1;
                else 
                	return 0;
            }
        });
        
        ListNode mergedList = new ListNode(0);
        ListNode mergedPtr = mergedList;
        
        for(ListNode list : lists) {
            if(list != null) 
            	q.add(list);
        }
        
        while(!q.isEmpty()) {
            // mergedPtr = mergedPtr.next = q.poll(); equivelent
            mergedPtr.next = q.poll();
            mergedPtr = mergeedPtr.next;
            
            if(mergedPtr.next != null) 
            	q.add(mergedPtr.next);
        }
        return mergedList.next;
    }
}
