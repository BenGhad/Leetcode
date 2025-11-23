class Solution:
    def maxSumMulti(self, nums: List[int], mult: int) -> int:
        best = 0
        cur = 0

        for num in (num * mult for num in nums):
            cur += num
            if cur < 0:
                cur = 0
            best = max(cur, best)
        
        return best


    def maxSubarraySumCircular(self, nums: List[int]) -> int:
        # forget about circular
        # Find max sum, find min sum
        # max(max, sum - min)
        m = max(nums)
        if m < 0: return m
        
        return max(self.maxSumMulti(nums, 1), sum(nums) + self.maxSumMulti(nums, -1))


