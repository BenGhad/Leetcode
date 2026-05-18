class Solution:
    def maximalSquare(self, mat: List[List[str]]) -> int:
        n = len(mat)
        m = len(mat[0])

        dp = [[int(mat[i][j]) for j in range(m)] for i in range(n)] 

        """
        dp[i][j] = side length of square ending at this 1
        dp[i][j]: if dp[i+1][j+1], check row + col and update ts 
        """

        ans = 0

        for i in range(n):
            for j in range(m):
                ans = max(ans, dp[i][j])

                if dp[i][j] == 0: continue    
                if i == 0 or j == 0: continue


                for sz in range(dp[i-1][j-1] + 1):
                    if dp[i-sz][j] == 0:
                        break

                    if dp[i][j-sz] == 0:
                        break 

                    dp[i][j] = sz + 1
                
                
                ans = max(ans, dp[i][j])
        
        return ans * ans
        
