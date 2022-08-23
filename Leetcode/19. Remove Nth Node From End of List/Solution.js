/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
 var removeNthFromEnd = function(head, n) {
  let fast = head;
  let slow = head;
  let prev = head;
  for(let i = 0 ; i < n ; i++) {
      fast = fast.next;
  }

  while(fast !== null) {
      fast = fast.next;
      prev = slow;
      slow = slow.next;
  }
  prev.next = slow.next;

  //head was deleted?
  return (slow === head) ? head.next : head;
};