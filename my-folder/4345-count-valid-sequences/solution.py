class Solution:
    def countValidSequences(self, n: int, k: int) -> int:
        MOD = 1000000007

        """
        stars n bars
        
        """

        totes = math.comb(n-1, k-1)

        """
        all odds
        still stars and bars

        2k+1

        2(x1x2x3...) + k
        == n-k//2
        """
        
        odds = math.comb(
            (n-k)//2+k-1,
            k-1,
        ) if (n-k)%2 == 0 else 0

        return (totes - odds) % MOD
        
