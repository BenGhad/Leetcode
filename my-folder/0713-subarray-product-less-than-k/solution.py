class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        if k == 0: return 0
        i = 0
        multi = 1
        ans = 0

        for j in range(len(nums)):
            multi *= nums[j]

            while multi >= k and i < j:
                multi /= nums[i]
                i += 1

            if multi < k:
                ans += (j - i + 1)

        return ans    
        
            
