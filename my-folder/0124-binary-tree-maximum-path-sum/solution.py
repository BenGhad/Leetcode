# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

"""
Options:
MaxPath(l downwards)
MaxPath(r downwards)


"""
class Solution:
    best = float('-inf')
    def maxPathSum(self, root: Optional[TreeNode]) -> int:
        Solution.populate(self, root)
        return self.best

    def populate(self, root):
        if root is None:
            return 0
        
        lB = Solution.populate(self, root.left)
        rB = Solution.populate(self, root.right)

        self.best = max(self.best, max(0, lB) + root.val + max(0, rB))

        

        return max(0, root.val + max(0, lB, rB))
        

