# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countDominantNodes(self, root: TreeNode | None) -> int:
        _, cnt = self.countDomV(root)
        return cnt
        
    def countDomV(self, root):
        if root is None:
            return 0, 0

        lV, lD = self.countDomV(root.left)
        rV, rD = self.countDomV(root.right)

        if root.val >= max(lV, rV):
            return root.val, lD + rD + 1
        else:
            return max(lV, rV), lD + rD
