class Solution:
    def countGoodStrings(self, low: int, high: int, zero: int, one: int) -> int:
        MOD = 1000000007
        dp = [0] * (high + 1)
        dp[zero] += 1
        dp[one] += 1

        for i in range(min(zero, one), high):
            count = dp[i]
            dp[i] %= MOD
            if i + zero <= high:
                dp[i + zero] += dp[i]
            if i + one <= high:
                dp[i + one] += dp[i]

        return sum(num % MOD for num in dp[low:]) % MOD
