class Solution:
    def maxCoins(self, piles: List[int]) -> int:
        n = len(piles) // 3
        piles = (sorted(piles))[n:]
        return sum([piles[i] for i in range(0, 2 * n, 2)])
