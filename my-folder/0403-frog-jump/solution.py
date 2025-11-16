class Solution:
    def canCross(self, stones: List[int]) -> bool:
        if stones[1] != 1: return False
        # dp[i][k] bool: can I reach stones[i] with my last jump of value k?
        n = len(stones)
        dp = [[False for _ in range(n + 1)] for _ in range(n)]

        posToIdx = {}
        for i in range(n):
            posToIdx[stones[i]] = i
        
        dK = [-1, 0, 1]

        dp[1][1] = True
        
        for i in range(n-1):
            for k in range(n + 1):
                if not dp[i][k]: continue
                for d in dK:
                    step = k + d
                    nxt = stones[i] + step
                    if nxt in posToIdx:
                        j = posToIdx[nxt]
                        if j == n-1: return True
                        dp[j][step] = True
                


        for stat in dp[n - 1]:
            if stat: return True
        
        return False
                

