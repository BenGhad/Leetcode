# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rob(self, root: Optional[TreeNode]) -> int:
        return max(self.dp(root))


    def dp(self, root: Optional[TreeNode]) -> tuple[int, int]:
        if root is None: return (0, 0)

        (robL, safeL) = self.dp(root.left)
        (robR, safeR) = self.dp(root.right)

        return (
            root.val + safeL + safeR,
            max(robL, safeL) + max(robR, safeR)
        )


