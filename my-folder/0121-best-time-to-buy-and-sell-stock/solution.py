class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        
        lo = float('inf')
        
        for p in prices:
            ans = max(ans, p - lo)
            lo = min(lo, p)
        return ans
