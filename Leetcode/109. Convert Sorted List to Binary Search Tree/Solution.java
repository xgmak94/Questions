/* https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.


/* Same as array to BST but with a sorted list, we get the middle element of the sorted list and set it as the root,
then each child is the middle of the respective halves of the array
*/

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        
        return toBST(head, null);
    }
    
    public TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        
        if(head == tail) return null;
        
        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode newNode = new TreeNode(slow.val);
        newNode.left = toBST(head, slow);
        newNode.right = toBST(slow.next, tail);
        
        return newNode;
    }
}
