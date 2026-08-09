class Solution:
    def minPrice(self, prices: list[int], discounts: list[int]) -> float:
        prices = sorted(prices, reverse=True)
        discounts = sorted(discounts, reverse=True)
        ans = 0.0

        for i in range(len(prices)):
            dih = discounts[i] if i < len(discounts) else 0
            p = float(prices[i])
            ans += (p * (100 - dih)) / 100.0

        return ans
