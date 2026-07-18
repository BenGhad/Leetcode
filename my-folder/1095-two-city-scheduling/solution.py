class Solution:
    def twoCitySchedCost(self, costs: List[List[int]]) -> int:
        """
        dp[i][j]
        i'th person
        j people in city B
        """
        
        n = len(costs)
        dp = [[float('inf') for _ in range(n)] for _ in range(n)]
        
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        
        for i, cost in enumerate(costs):
            ca = cost[0]
            cb = cost[1]
            
            for j in range(n):
                dp[i][j] = min(dp[i][j], dp[i-1][j] + ca, dp[i-1][j-1] + cb)
        
        ans = float('inf')
        
        
        return dp[n-1][n//2]
            
        
        
        
        
