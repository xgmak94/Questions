# Definition for singly-linked list.
class ListNode(object):
     def __init__(self, val=0, next=None):
         self.val = val
         self.next = next
class Solution(object):
    def addTwoNumbers(self, l1, l2):
        carry = 0
        tot = ListNode(0)
        n = tot
        while(l1 or l2 or carry):
            v1 = 0
            v2 = 0
            if(l1):
                v1 = l1.val
                l1 = l1.next
            if(l2):
                v2 = l2.val
                l2 = l2.next
            n.next = ListNode((v1+v2+carry) % 10)
            carry = (v1+v2+carry) / 10
            n = n.next
        return tot.next
        
list1 = ListNode(2)
list1.next = ListNode(4)
list1.next.next = ListNode(3)

list2 = ListNode(5)
list2.next = ListNode(6)
list2.next.next = ListNode(4)

solution = Solution()
tot = solution.addTwoNumbers(list1, list2)

