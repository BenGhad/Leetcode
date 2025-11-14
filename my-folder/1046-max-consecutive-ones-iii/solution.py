class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        l = 1
        r = len(nums)
        best = 0
        while l <= r:
            m = l + (r - l) // 2
            if Solution.can(m, nums, k):
                best = max(best, m)
                l = m + 1
            else:
                r = m - 1
        
        return best

    def can(m, nums, k) -> bool:
        for i in range(m):
            if nums[i] == 0:
                k -= 1
        
        if k >= 0:
            return True

        for i in range(m, len(nums)):
            print(k)
            if nums[i - m] == 0:
                k += 1
            if nums[i] == 0:
                k -= 1
            if k >= 0:
                return True
        return False
