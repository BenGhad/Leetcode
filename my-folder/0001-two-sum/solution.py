class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        vis = {}
        
        for i, n in enumerate(nums):
            if n in vis and n + n == target:
                return [vis[n], i]
            vis[n] = i
        
        for i, n in enumerate(nums):
            if target - n != n and target - n in vis:
                return (i, vis[target - n])
        
        return [-1, -1]
