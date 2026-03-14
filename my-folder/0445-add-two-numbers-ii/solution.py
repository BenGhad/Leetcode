# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def siz(node):
        ans = 0
        while node is not None:
            ans += 1
            if node.next is not None:
                node = node.next
    
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        s1 = []
        s2 = []
        
        while l1:
            s1.append(l1.val)
            l1 = l1.next
            
        while l2:
            s2.append(l2.val)
            l2 = l2.next
        
        
        carry = 0
        ans = None
        
        while s1 or s2 or carry:
            a = s1.pop() if s1 else 0
            b = s2.pop() if s2 else 0
            
            num = a + b + carry
            
            carry = (num > 9)
            ans = ListNode(num % 10, ans)
        return ans
            
