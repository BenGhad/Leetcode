class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n = len(prices)
        ans = [0] * n
        ans[-1] = prices[-1]
        mins = []

        for i in range(n-1, -1, -1):
            while mins and mins[-1] > prices[i]:
                mins.pop()

            ans[i] = prices[i] - (mins[-1] if mins else 0)
            
            mins.append(prices[i])
        
        return ans
