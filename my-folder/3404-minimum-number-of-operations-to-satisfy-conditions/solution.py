class Solution:
    def minimumOperations(self, grid: List[List[int]]) -> int:
        # dp[col][number] <= 10^4, must compare rows
        """

        dp[col][number] =
            operationCost for col = number
            min(dp[col - 1]) != number
        """
        ans = 0

        n = len(grid) # rows
        m = len(grid[0]) # columns
        
        dp = [ [float('inf') for _ in range(10)] for _ in range(m+1)]
        
        # 1 of these is proc
        dp[0][0] = 0
        dp[0][1] = 0 

        for col in range(1, m+1):
            for num in range(10):
                cost = float('inf')                
                
                for pNum in range(10):
                    if num == pNum: continue
                    cost = min(cost, dp[col-1][pNum])
                
                for idx in range(n):
                    if grid[idx][col-1] != num: cost+= 1

                dp[col][num] = cost

        return min(dp[m])
