# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        if (not p) != (not q):
            return False 
        
        if not p:
            return True

        if p.val != q.val:
            return False

        if (p.left is None) != (q.left is None):
            return False
        
        if (p.right is None) != (q.right is None):
            return False

        if p.left and not Solution.isSameTree(self, p.left, q.left): return False
        
        if p.right and not Solution.isSameTree(self, p.right, q.right): return False
        
        return True
