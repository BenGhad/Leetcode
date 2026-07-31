class Solution:
    def bulbSwitch(self, n: int) -> int:
        ans = 1

        while ans * ans <= n:
            ans += 1
        return ans-1
