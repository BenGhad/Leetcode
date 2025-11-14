# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        aPrev = list1
        bPost = list1

        for i in range(a - 1):
            aPrev = aPrev.next
        for i in range(b + 1):
            bPost = bPost.next
        
        aPrev.next = list2

        while list2.next:
            list2 = list2.next

        list2.next = bPost

        return list1
