class Solution:
    def maxNonDecreasingLength(self, nums1: List[int], nums2: List[int]) -> int:
        # dp[i][j] = longest if i end at i with numsj
        n = len(nums1)
        dp = [[1, 1] for _ in range (n)]

        dp[0][0] = 1
        dp[0][1] = 1
        
        ans = 1
        
        for i in range(1, n):
            if(nums1[i] >= nums1[i-1]):
                dp[i][0] = dp[i-1][0] + 1
                
            if nums1[i] >= nums2[i-1]:
                dp[i][0] = max(dp[i][0], dp[i-1][1] + 1) 

            ans = max(dp[i][0], ans)

            if(nums2[i] >= nums2[i-1]):
                dp[i][1] = dp[i-1][1] + 1

            if(nums2[i] >= nums1[i-1]):
                dp[i][1] = max(dp[i][1], dp[i-1][0] + 1)
            
            ans = max(dp[i][1], ans)
        return ans

