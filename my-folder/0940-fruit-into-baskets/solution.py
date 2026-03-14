class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        # dp[i] = best if i stop and pick this fruit
        n = len(fruits)
        if n <= 2: return n
        ans = 0
        latest = {}
        l = 0
        bask = [-1, -1]
        
        for r in range(0, n):
            fr = fruits[r]
            latest[fr] = r
            
            if fr not in bask:
                if bask[0] == -1:
                    bask[0] = fr
                elif bask[1] == -1:
                    bask[1] = fr
                else:
                    
                    la = latest[bask[0]]
                    lb = latest[bask[1]]
                    fa = 0
                    fb = 1
                    if la > lb:
                        la, lb = lb, la
                        fa, fb = fb, fa
                    # la early
                    l = la + 1
                    bask[fa] = fr
            ans = max(ans, r-l+1)
        
        return ans
                    
                    
