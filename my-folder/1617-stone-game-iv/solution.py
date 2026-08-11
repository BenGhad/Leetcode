class Solution:
    """
    0 - F
    1 - T
    2 - F
    3 - T
    4 - T
    5 - F
    6 - T
    7 - F

    """
    def winnerSquareGame(self, n: int) -> bool:
        dp = [False] * (n+1)
        if n == 1:
            return True

        dp[0] = False
        dp[1] = True
        squares = []
        sq = 1
        
        for i in range(2, n+1):
            if sq * sq <= i:
                squares.append(sq * sq)
                sq += 1
            
            for sc in squares:
                if dp[i-sc] == False:
                    dp[i] = True
                    break
            
        return dp[n]
