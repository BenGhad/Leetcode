class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        vis = {}
        big = max(nums)
        smol = min(nums)
        for num in nums:
            vis[num] = num
        
        ans = []
        for num in range(smol, big):
            if num not in vis:
                ans.append(num)
        return ans
