class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        if k <= 1: return True
        one = float('-inf')
        n = len(nums)
        for i in range(n):
            if nums[i] == 1:
                if i - one - 1 < k:
                    return False
                one = i
        
        return True
