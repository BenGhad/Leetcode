class Solution:
    def largestInteger(self, n: int, s: int) -> int:
        if n * 9 < s:
            return -1

        ans = 0

        for _ in range(n):
            ans *= 10
            ans += min(9, s)
            s = max(0, s - 9)

        return ans
