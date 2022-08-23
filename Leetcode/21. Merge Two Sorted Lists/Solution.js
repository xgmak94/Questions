/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
 var mergeTwoLists = function(list1, list2) {
  let newHead = new ListNode();
  let mergedList = newHead;

  while(list1 !== null && list2 !== null) {
      if(list1.val < list2.val) {
          mergedList.next = list1;

          list1 = list1.next;
          mergedList = mergedList.next;
      }
      else {
          mergedList.next = list2;

          list2 = list2.next;
          mergedList = mergedList.next;
      }
  }

  if(list1 !== null) {
      mergedList.next = list1;
  }
  if(list2 !== null) {
      mergedList.next = list2;
  }
  return newHead.next;
};