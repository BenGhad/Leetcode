class Solution:
    def minPairSum(self, nums: List[int]) -> int:
        nums = sorted(nums)
        n = len(nums)
        ans = -1
        for i in range(n):
            ans = max(ans, nums[i] + nums[n - 1 - i])
        
        return ans
