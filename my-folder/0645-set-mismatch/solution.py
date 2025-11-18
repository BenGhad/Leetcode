class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        vis = {}
        ans = [-1, -1]
        for i in nums:
            if i in vis:
                ans[0] = i
            vis[i] = True

        for i in range(len(nums)):
            if i+1 not in vis:
                ans[1] = i+1
                return ans
        
        return [-1, -1]
