class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        n = len(nums)
        dp = [-1] * n
        dp[0] = 1
        ans = 1
        for i in range(1, n):
            lic = 1
            for j in range(i):
                if nums[j] < nums[i]:
                    lic = max(lic, dp[j] + 1)
            dp[i] = lic
            ans = max(ans, dp[i])
        
        return ans
