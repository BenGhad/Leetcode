# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:
            if root is None:
                return 0
            
            ans = self.ps(root, targetSum)
            ans += self.pathSum(root.left, targetSum)
            ans += self.pathSum(root.right, targetSum)

            return ans
    def ps(self, root, targetSum): 
        if root is None:
            return 0
        
        ans = 0

        # Path ends here 
        if targetSum == root.val:
            ans += 1

        ans += self.ps(root.left, targetSum - root.val)
        ans += self.ps(root.right, targetSum - root.val)

        return ans
