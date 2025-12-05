class Solution:
    def countPartitions(self, nums: List[int]) -> int:
        s = sum(nums)
        l = 0
        ans = 0
        for num in nums:
            if (l - s) % 2 == 0:
                ans += 1
            
            l += num
            s -= num
        
        if ans > 0: ans -= 1
            

        return ans
