class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        prof = 0
        prev = float('inf')
        for price in prices:
            if price < prev:
                prev = price
            else:
                prof += (price - prev)
                prev = price
                
        return prof
