class Solution:
    def divisorGame(self, n: int) -> bool:
        if n < 2: return False
        dp = [False] * (n+1)
        dp[0] = False
        dp[1] = False
        dp[2] = True

    
        for i in range(3, n+1):
            for k in range(1, i // 2):
                if i % k == 0 and not dp[i - k]:
                    dp[i] = True
                    break
        return dp[n]
