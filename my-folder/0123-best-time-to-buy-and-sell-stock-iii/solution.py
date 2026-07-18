class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        dp[i][j] = total $$$
        
        Buying the first stock
        dp[i][0] = max(
                    -prices[i],  # Buy now
                    dp[i-1][0]  # Buy best stock before
                    )

        Selling the first stock
        dp[i][1] = max(
                    dp[i-1][1],   # sold earlier
                    dp[i-1][0] + prices[i] # bought earlier, sold now
                    )

        Buying the 2nd stock
        dp[i][2] = max(
                    dp[i-1][2] # already bought
                    dp[i-1][1] - prices[i] # Already sold, bought now 
        )

        Selling the 2nd stock

        dp[i][3] = max(
                    dp[i-1][3] # already sold we done
                    dp[i-1][2] + prices[i] # Already Bought, sold NOW
        )
        """
        
        TRANSACTIONS = 2
        n = len(prices)

        #skibidis
        if n < 2:
            return 0
        if n < 4:
            # Buy 1 sell 1
            ans = 0
            for i in range(n):
                for j in range(i+1, n):
                    ans = max(ans, prices[j] - prices[i])
            return ans

        dp = [[0 for _ in range(TRANSACTIONS * 2)]for _ in range(n)]

        # Buying the first stock
        dp[0][0] = -prices[0]
        for i in range(1, n):
            dp[i][0] = max(dp[i-1][0], -prices[i])

        # Selling the first stock
        dp[0][1] = -float('inf')
        for i in range(1, n):
            dp[i][1] = max(dp[i-1][1], dp[i-1][0] + prices[i])        
        
        # Buying 2nd stock
        dp[0][2] = -float('inf')
        dp[1][2] = -float('inf')
        for i in range(2, n):
            dp[i][2] = max(dp[i-1][2], dp[i-1][1] - prices[i])
        
        # Selling 2nd stock
        dp[2][3] = -float('inf')
        for i in range(3, n):
            dp[i][3] = max(dp[i-1][3], dp[i-1][2] + prices[i])

        return max(dp[n-1][1], dp[n-1][3], 0)
