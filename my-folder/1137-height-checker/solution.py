class Solution:
    def heightChecker(self, heights: List[int]) -> int:
        rizz = sorted(heights)
        ans = 0
        
        for a, b in zip(heights, rizz):
            if a != b:
                ans += 1
        return ans
