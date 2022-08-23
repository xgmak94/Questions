/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
 var reorderList = function(head) {
  let slow = head;
  let fast = head;

  while(fast !== null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
  }
  let temp = slow.next;
  slow.next = null;
  slow = temp;

  let secondHalf = reverseList(slow);
  let firstHalf = head;

  while(firstHalf !== null && secondHalf != null) {
      let firstNext = firstHalf.next;
      let secondNext = secondHalf.next;

      firstHalf.next = secondHalf;
      secondHalf.next = firstNext;

      firstHalf = firstNext;
      secondHalf = secondNext;
  }
};

var reverseList = function(head) {
  let prev = null;
  while(head !== null) {
    const next = head.next;
    head.next = prev;

    prev = head;
    head = next;
  }
  return prev;
};