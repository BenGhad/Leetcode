class Solution:
    def findLength(self, nums1: List[int], nums2: List[int]) -> int:
        # dp[i][j] = longest up to i, j
        n = len(nums1)
        m = len(nums2)
        
        dp = [[0 for _ in range(m+1)] for _ in range(1+n)]

        ans = 0

        for i in range(1, n+1):
            for j in range(1, m+1):
                ai = i-1
                aj = j-1

                if(nums1[ai] == nums2[aj]):
                    dp[i][j] = dp[i-1][j-1] + 1
                
                ans = max(ans, dp[i][j])

        return ans    

