class Solution:
    def maxDistToClosest(self, seats: List[int]) -> int:
        n = len(seats)
        
        lDist = [0] * n
        
        if seats[0] == 0:
            lDist[0] = n
        
        for i in range(1, n):
            if seats[i] != 0:
                lDist[i] = 0
            else:
                lDist[i] = lDist[i-1] + 1
        
        rDist = [0] * n
        if seats[-1] == 0:
            rDist[-1] = n
        
        for i in range(n-2, -1, -1):
            if seats[i] != 0:
                rDist[i] = 0
            else:
                rDist[i] = rDist[i+1] + 1
        
        ans = 0
        for i in range(n):
            ans = max(ans, min(lDist[i], rDist[i]))
        
        return ans
            
            
            
