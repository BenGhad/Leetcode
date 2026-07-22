# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def balanceBST(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None
        
        self.shart = self.inord(root)
        
        return self.diddy(0, len(self.shart)-1)
        
    
    def diddy(self, l, r) -> TreeNode:
        if l > r:
            return None
        
        m = l + (r-l)//2
        
        return TreeNode(self.shart[m], self.diddy(l,m-1), self.diddy(m+1,r))

        
    
    def inord(self, root):
        ans = []
        def dfs(node):
            if node is None:
                return 
            dfs(node.left)
            ans.append(node.val)
            dfs(node.right)
        
        dfs(root)
        return ans
