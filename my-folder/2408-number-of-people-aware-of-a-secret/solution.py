class Solution(object):
    def peopleAwareOfSecret(self, n, delay, forget):
        """
        :type n: int
        :type delay: int
        :type forget: int
        :rtype: int
        """
        MOD = 10**9 + 7
        dp = [0] * (n + 1)
        dp[1] = 1
        share = 0

        for t in range(2, n + 1):
            if t - delay > 0:
                share = (share + dp[t - delay]) % MOD
            if t - forget > 0:
                share = (share - dp[t - forget]) % MOD
            
            dp[t] = share
        
        ans = 0
        for i in range(n - forget + 1, n + 1):
            ans = (ans + dp[i]) % MOD
        return ans
